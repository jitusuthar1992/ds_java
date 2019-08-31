package main.java1.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

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
        }
    }
}
