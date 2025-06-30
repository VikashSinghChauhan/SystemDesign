package org.example;


import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

// ======== Command pattern for job abstraction ============
interface Job{
    void execute();
    String name();
}

// ======== Strategy Pattern for Scheduling Types ============
abstract class ScheduledJob implements Comparable<ScheduledJob> {
    private final Job job;
    private long nextExecutionTime;

    ScheduledJob(Job job, long nextExecutionTime) {
        this.job = job;
        this.nextExecutionTime = nextExecutionTime;
    }

    public Job getJob() {
        return job;
    }

    public long getNextExecutionTime() {
        return nextExecutionTime;
    }

    public void setNextExecutionTime(long nextExecutionTime) {
        this.nextExecutionTime = nextExecutionTime;
    }

    public abstract void updateNextExecutionTime();

    @Override
    public int compareTo(ScheduledJob o) {
        return Long.compare(this.nextExecutionTime, o.nextExecutionTime);
    }
}


// One-time Scheduled Jobs
class OneTimeJob extends ScheduledJob{

    OneTimeJob(Job job, long nextExecutionTime) {
        super(job, nextExecutionTime);
    }

    @Override
    public void updateNextExecutionTime() {
        // do nothing
    }
}


//Recurring Job

class RecurringJob extends ScheduledJob{

    private final long intervalMillis;
    public RecurringJob(Job job, long nextExecutionTime, long intervalMillis) {
        super(job, nextExecutionTime);
        this.intervalMillis = intervalMillis;
    }

    @Override
    public void updateNextExecutionTime() {
        long newTime = getNextExecutionTime() + intervalMillis;
        // set next execution time
        this.setNextExecutionTime(newTime);
    }
}


public class JobScheduler {

    private final PriorityBlockingQueue<ScheduledJob> jobQueue = new PriorityBlockingQueue<>();
    private final ExecutorService workerPool;
    private final int workerCount;
    private final Thread dispatcherThread;
    private volatile boolean isRunning = true;

    public JobScheduler(int workerCount) {
        this.workerCount = workerCount;
        this.workerPool = Executors.newFixedThreadPool(workerCount);
        this.dispatcherThread = new Thread(this :: dispatchLoop, "Job-Dispatcher");
        dispatcherThread.start();
    }

    public void scheduleOneTimeJob(Job job, long timestampMillis)
    {
        jobQueue.add(new OneTimeJob(job, timestampMillis));
    }

    public void scheduleRecurringJob(Job job, long initialTimeMillis, long intervalMillis){
        jobQueue.add(new RecurringJob(job, initialTimeMillis, intervalMillis));
    }

    private void dispatchLoop(){
        while(isRunning){
            try{
                ScheduledJob scheduledJob = jobQueue.peek(); //<-- use peek instaed of take()

                if(scheduledJob == null)
                {
                    Thread.sleep(100); //wait if no jobs
                    continue;
                }

                long now = System.currentTimeMillis();
                long delay = scheduledJob.getNextExecutionTime() - now;

                if(delay > 0){
                    Thread.sleep(Math.min(delay, 100));  //Not ready yet, wait
                    continue;
                }

                // Now the job is ready, remove it from the queueu
                jobQueue.poll(); // safe to remove now

                //Execute the job
                workerPool.submit(()->{
                    try{
                        scheduledJob.getJob().execute();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });


                //Reschedule if recurring
                if(!(scheduledJob instanceof OneTimeJob)){
                    scheduledJob.updateNextExecutionTime();
                    jobQueue.add(scheduledJob);
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown(){
        isRunning = false;
        dispatcherThread.interrupt();
        workerPool.shutdown();
    }
}


// ======= Sample Job Implementations =======
class PrintJob implements  Job{
    private final String name;

    PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("Executing job : " + name +" at " + new Date());
    }

    @Override
    public String name() {
        return name;
    }
}
