package com.security.secure.ratelimiters;


import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

class LeakyBucket implements LeakyBucketInterface {
    private final long capacity;
    private final double leakRate;       //like 1 request in 10milliseconds, 100 milliseconds
    private final Queue<Instant> bucket;

    private Instant lastLeakTimestamp;

    private final ScheduledExecutorService scheduler;

    public LeakyBucket(long capacity, double leakRate)
    {
        this.capacity = capacity;                   //Maximum number of requests that bucket can hold
        this.leakRate = leakRate;                   //Rate at which requests leak out of the bucket (requests per second)
        this.bucket = new ArrayDeque<>();           //Queue to hold timestamps of requests
        this.lastLeakTimestamp = Instant.now();     //Last tiem we leaked from the bucket


        /**
         * Is it Thread Safe ?
         *
         * Single threaded execution:
         * - Since the thread pool has only one thread (newScheduledThreadPool(1)), the leak method run in a single threaded context
         * - No race conditons between multiple threads inside this scheduled task.
         */

        this.scheduler = Executors.newScheduledThreadPool(1);
        this.scheduler.scheduleAtFixedRate(this::leak, 10, (long) leakRate, TimeUnit.MILLISECONDS);
    }

    public synchronized boolean allowRequest(){
        if(bucket.size() < capacity){
            bucket.offer(Instant.now());
            System.out.println("Added to queue");
            return true;
        }
        System.out.println("Drop");
        return false;
    }


    private synchronized  void leak() {
        if(!bucket.isEmpty()){
            bucket.poll();
            System.out.println("Leak");
        }
    }

    public void stopLeaking(){
        scheduler.shutdown();
    }


}

interface LeakyBucketInterface{
    public boolean allowRequest();

}
public class LeakyBucketMain {

    //Singleton instace of Leaky Bucket if we want global contorl over API rates.

    //Per-User Rate limiting useing a Map based on userId/IP

    /**
     * Each user gets their own bucket
     * Prevents one user from consuming all capacity
     */

    private static final Map<String, LeakyBucket> userBuckets = new ConcurrentHashMap<>();

    public static boolean isAllowed(String userId){
        userBuckets.putIfAbsent(userId, new LeakyBucket(10,100));
        return userBuckets.get(userId).allowRequest();
    }

    public static void main(String args[])
    {
        for(int i=0;i<1000;i++)
        LeakyBucketMain.isAllowed("vikash");

    }

}






