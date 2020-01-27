package main.java1.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.kumar01
 * 31/12/19
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingDeque<>();

       new Thread( new Producer1(sharedQueue)).start();
       new Thread( new Consumer1(sharedQueue)).start();

    }
}


class Producer1 implements Runnable{

    private BlockingQueue<Integer> sharedQueue;

    public Producer1(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Produced :"+i);
            try {
                sharedQueue.put(i);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer1 implements Runnable{
    private BlockingQueue<Integer> sharedQueue;

    public Consumer1(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Consumer : "+sharedQueue.take());
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
