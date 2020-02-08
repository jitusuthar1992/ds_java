package main.java1.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author jitendra.kumar01
 * 08/02/20
 */
public class SynchronousQueueExample {
    public static void main(String[] args) throws InterruptedException {

        shareStateUsingCountDownLatch();

        shareStateUsingSynchronousQueue();
    }

    static void shareStateUsingCountDownLatch() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicInteger sharedState = new AtomicInteger();

        CountDownLatch latch = new CountDownLatch(1);

        Runnable producer = () -> {
            Integer producedElement = ThreadLocalRandom
                    .current()
                    .nextInt();

            sharedState.set(producedElement);
            latch.countDown();
            System.out.println("Saving an element: "+producedElement +"  to the exchange point");

        };

        Runnable consumer = () -> {
            Integer consumedElement = sharedState.get();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consume an element: "+consumedElement +"  to the exchange point");

        };

        service.execute(producer);
        service.execute(consumer);

        service.awaitTermination(500, TimeUnit.MILLISECONDS);
        service.shutdown();
    }


    static void shareStateUsingSynchronousQueue() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Runnable producer = () -> {
            Integer producedElement = ThreadLocalRandom
                    .current()
                    .nextInt();
            try {
                queue.put(producedElement);
                System.out.println("Saving an element: "+producedElement +"  to the exchange point");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                Integer consumedElement = queue.take();
                System.out.println("Consume an element: "+consumedElement +"  to the exchange point");

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };

        service.execute(producer);
        service.execute(consumer);

        service.awaitTermination(500, TimeUnit.MILLISECONDS);
        service.shutdown();
    }

}
