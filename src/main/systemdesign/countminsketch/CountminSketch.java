package main.systemdesign.countminsketch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CountminSketch {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Character> blockingQueue = new LinkedBlockingQueue();

        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
