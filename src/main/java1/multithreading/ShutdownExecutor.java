package main.java1.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ShutdownExecutor {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        System.out.println("WorkerTasks scheduled at : " + LocalDateTime.now());

        ScheduledFuture<String> result1 = executor.schedule(new WorkerTask(
                "WorkerTask-1"), 10, TimeUnit.SECONDS);

        ScheduledFuture<String> result2 = executor.schedule(new WorkerTask(
                "WorkerTask-2"), 20, TimeUnit.SECONDS);

        ScheduledFuture<String> result3 = executor.schedule(new WorkerTask(
                "WorkerTask-3"), 30, TimeUnit.SECONDS);

        Thread.sleep(15_000);
        System.out.println("***********Shutting down the executor service*********");
        //shutdownAndAwaitTermination(executor);
        executor.shutdown();

        System.out.println("***********Tasks are partially completed*********");

        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        System.out.println("Task-3 is done : " + result3.isDone());

        System.out.println("***********Waiting for tasks to be complete*********");
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("***********All tasks are completed now*********");

        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        System.out.println("Task-3 is done : " + result3.isDone());
    }

    static void shutdownAndAwaitTermination(ExecutorService pool) {
        // Disable new tasks from being submitted
        pool.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                // Cancel currently executing tasks forcefully
                pool.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

class WorkerTask implements Callable<String> {
    private final String name;

    public WorkerTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("WorkerTask [" + name + "] executed on : "
                + LocalDateTime.now());
        return "WorkerTask [" + name + "] is SUCCESS !!";
    }
}

