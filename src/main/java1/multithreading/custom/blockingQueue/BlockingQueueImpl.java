package main.java1.multithreading.custom.blockingQueue;

/**
 * @author jitendra.kumar01
 * 22/02/20
 */
public class BlockingQueueImpl {
    final Object[] items = new Object[100];
    int putPtr, takePtr, count;

    public synchronized void put(Object obj) throws InterruptedException {
        while (count == items.length) {
            wait();
        }
        items[putPtr] = obj;
        putPtr++;
        if (putPtr == items.length) {
            takePtr = 0;
        }
        count++;
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Object obj = items[takePtr];
        takePtr++;
        if (takePtr == items.length) {
            takePtr = 0;
        }
        --count;
        notifyAll();
        return obj;
    }
}
