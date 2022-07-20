package main.java1.multithreading;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jitendra.kumar01
 * 30/12/19
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new DemoTask1());
        service.submit(new DemoTask1());
        service.shutdown();
    }
}

class DemoTask1 implements Runnable {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public int getThreadId() {
        return threadId.get();
    }

    // Returns the current thread's starting timestamp
    private static final ThreadLocal<Date> startDate = ThreadLocal.withInitial(() -> new Date());


    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
    }
}