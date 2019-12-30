package main.java1.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jitendra.kumar01
 * 13/11/19
 */
public class ThreeThreadsOrderedLockLess {

    AtomicInteger sharedOutput = new AtomicInteger(0);
    private Object object = new Object();
    public static void main(String args[]) throws InterruptedException{
        ThreeThreadsOrderedLockLess t = new ThreeThreadsOrderedLockLess();
        MyThread t1 = t.new MyThread(0);
        MyThread t2 = t.new MyThread(1);
        MyThread t3 = t.new MyThread(2);

        Thread ts1 = new Thread(t1);
        Thread ts2 = new Thread(t2);
        Thread ts3 = new Thread(t3);
        ts1.setName("Thread1");
        ts2.setName("Thread2");
        ts3.setName("Thread3");
        ts1.start();
        ts2.start();
        ts3.start();

    }


    private class MyThread implements Runnable{
        private final int threadPosition;
        public MyThread(int threadPosition) {
            super();
            this.threadPosition = threadPosition;
        }

        @Override
        public void run() {
            while (sharedOutput.get() < 9) {

                synchronized (object) {

                    if (sharedOutput.get() % 3 == this.threadPosition) {

                        if(sharedOutput.get() < 9)
                            System.out.println(Thread.currentThread()+"  "+
                                                       sharedOutput.incrementAndGet());
                    }
                }
            }
        }
    }
}
