package main.java1.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.kumar01
 * 27/12/19
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i <1000 ; i++) {
            executorService.execute(new Task(String.valueOf(i),semaphore) );
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

     static class Task implements Runnable{
        String name ;

         Semaphore semaphore;
         public Task(String name,Semaphore semaphore) {
             this.name  = name;
             this.semaphore = semaphore;

         }

         @Override
        public void run() {

             if(!semaphore.tryAcquire()){
                // System.out.println("Doing something else by task :"+name);

             }
                 try {
                     semaphore.acquire();
                     System.out.println("availablePermits :"+semaphore.availablePermits());

                     System.out.println("Executing the task :"+name);
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

                 semaphore.release();




        }
    }
}

