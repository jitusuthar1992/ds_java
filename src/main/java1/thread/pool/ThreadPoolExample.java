package main.java1.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        /*ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());

            executor.submit(task);
        }
       executor.shutdown();
      try {
            if(executor.awaitTermination(4, TimeUnit.SECONDS)) {
                System.out.println("COmpleted");
            }
           else {
               System.out.println("Shutting down manually");
                executor.shutdownNow();

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Task task = new Task("Task " + 1);
        Thread t1 = new Thread(task);
        executor.execute(t1);
        Task task1 = new Task("Task " + 2);
        Thread t2 = new Thread(task1);
        executor.execute(t2);

        System.out.println("COmpleted");

    }
}
