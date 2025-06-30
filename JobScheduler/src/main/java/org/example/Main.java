package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        JobScheduler scheduler = new JobScheduler(3);
        long now = System.currentTimeMillis();
        scheduler.scheduleOneTimeJob(new PrintJob("One-time-1"), now + 2000);
        scheduler.scheduleOneTimeJob(new PrintJob("One-time-2"), now + 4000);

        scheduler.scheduleRecurringJob(new PrintJob("Recurring-Job-1"), now + 1000, 3000);
        scheduler.scheduleRecurringJob(new PrintJob("Recurring-Job-1"), now + 2000, 5000);


        Thread.sleep(15000); // Let the scheuelr run for 15 seconds
        scheduler.shutDown();
    }
}