package main.java1.multithreading.custom.blockingQueue;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author jitendra.kumar01
 * 22/02/20
 */
public class CustomBlockingQueueMain {

    public static void main(String[] args) {
        BlockingQueueAdVanceImpl customBlockingQueue = new BlockingQueueAdVanceImpl();
        // Creating producer and consumer threads

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerImpl(customBlockingQueue));
        executor.execute(new ConsumerImpl(customBlockingQueue));


    }
}

class ProducerImpl implements Runnable {

    private BlockingQueueAdVanceImpl customBlockingQueue;

    public ProducerImpl(BlockingQueueAdVanceImpl customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                customBlockingQueue.put(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ConsumerImpl implements Runnable {
    private BlockingQueueAdVanceImpl customBlockingQueue;

    public ConsumerImpl(BlockingQueueAdVanceImpl customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {

                customBlockingQueue.take();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

