package main.java1.multithreading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.kumar01
 * 31/12/19
 */
public class ScheduledThreadPoolExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Task task1 = new Task("Demo Task 1");
        Task task2 = new Task("Demo Task 2");
        System.out.println("The time is : " + new Date());

        /*executorService.schedule(task1, 5, TimeUnit.SECONDS);
        executorService.schedule(task1,10,TimeUnit.SECONDS);

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();*/


        //executorService.scheduleAtFixedRate(task1, 5,5, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(task1, 5, 5, TimeUnit.SECONDS);

    }
}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);

            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

