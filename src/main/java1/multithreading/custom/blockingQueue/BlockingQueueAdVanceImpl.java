package main.java1.multithreading.custom.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jitendra.kumar01
 * 22/02/20
 */
public class BlockingQueueAdVanceImpl {

    final Lock lock = new ReentrantLock();

    // Conditions
    final Condition produceCond  = lock.newCondition();
    final Condition consumeCond = lock.newCondition();

    // Array to store element for CustomBlockingQueue
    final Object[] array = new Object[6];
    int putIndex, takeIndex;
    int count;

    public void put(Object x) throws InterruptedException {

        lock.lock();
        try {
            while (count == array.length){
                // Queue is full, producers need to wait
                produceCond.await();
            }

            array[putIndex] = x;
            System.out.println("Producing - " + x);
            putIndex++;
            if (putIndex == array.length){
                putIndex = 0;
            }
            // Increment the count for the array
            ++count;
            consumeCond.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                // Queue is empty, consumers need to wait
                consumeCond.await();
            }
            Object x = array[takeIndex];
            System.out.println("Consuming - " + x);
            takeIndex++;
            if (takeIndex == array.length){
                takeIndex = 0;
            }
            // reduce the count for the array
            --count;
            // send signal producer
            produceCond.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}
