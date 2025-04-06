package com.security.secure.ratelimiters;

import java.time.Instant;


/**
 * Feature	                        double	                        Instant
 * Type	                      Primitive Data Type	                   Class (Reference Type)
 * Purpose	                  Stores decimal numbers	               Represents a specific point in time
 * Precision	              64-bit floating point	                   Nanosecond precision
 * Mutability	              Mutable (can be reassigned)            	Immutable (modifications create a new object)
 * Example Modification	      x = 5.5; x = 10.2; (value changes)	   instant.plusSeconds(5); (returns a new Instant)
 */
 class TokenBucket implements TokenBucInterface{

    private final long capacity;    // Maximum number of tokens the bucket can hold

    private final double fillRate;   //Rate at which tokens are added to the bucket (tokens per second)
    private double tokens;           //current number of tokens in the bucket
    private Instant lastRefillTimestamp;   // Last time we refilled the bucket


    public TokenBucket(long capacity, double fillRate)
    {
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.tokens = capacity;      // Start with a full bucket
        this.lastRefillTimestamp = Instant.now();
    }


    @Override
    public synchronized boolean allowRequest(double tokens)
    {
        refill();      //First, add any new tokens based on elapsed time

        if(this.tokens < tokens){
            return false;             // now enough tokens, request throttled
        }

        this.tokens = this.tokens - tokens;    // Consume the tokens
        return true;
    }


    /**
     * Expression	                                      Output Example	                           Meaning
     * System.out.println(now);	                    2025-03-29T14:30:15.123456789Z	          ISO-8601 UTC format (Instant.toString())
     * System.out.println(now.toEpochMilli());	           1743537015123	                  Epoch time in milliseconds since 1970-01-01T00:00:00Z (truncates nanoseconds)
     */
    private void refill(){
        Instant now = Instant.now();

        //Calculate how many tokens to add based on the time elasped
        double tokensToAdd = (now.toEpochMilli() - lastRefillTimestamp.toEpochMilli())*fillRate/1000.0;
        this.tokens = Math.min(capacity, this.tokens + tokensToAdd); // Add tokens, but don't exceed capacity
        this.lastRefillTimestamp = now;
    }


}


/**
 * Interfaces cannot have synchronized methods because they do not define method implementations.
 *
 * Apply synchronized in the implementing class, where the actual execution happens.
 *
 * If thread safety is needed, use synchronized, ReentrantLock, or atomic variables in the implementation.
 */

interface TokenBucInterface {
    public boolean allowRequest(double tokens);
}

public class Main{
    public static void main(String args []) throws InterruptedException {
        TokenBucInterface tokenBucket = new TokenBucket(10,2);

        for(int i=0;i<100;i++)
        {
            if(tokenBucket.allowRequest(2)){
                System.out.println("Request allowd");
            }
            else {
                System.out.println("Request throttled");
            }
            Thread.sleep(500);
        }
    }
}



