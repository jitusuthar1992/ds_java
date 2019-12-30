package main.java1.multithreading;


import java.util.concurrent.CountDownLatch;

/**
 * @author jitendra.kumar01
 * 18/12/19
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws  InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Worker1 wrk = new Worker1("W1",latch,3000l);
        Worker1 wrk1 = new Worker1("W2",latch,5000l);

        //Worker1 wrk2 = new Worker1("W3",latch,3000l);
        wrk.start();
        wrk1.start();
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                                   " has finished");

    }
}

class Worker1 extends Thread {

    private CountDownLatch latch;
    private Long delay ;

    public Worker1(String name ,CountDownLatch latch, Long delay) {
        super(name);
        this.latch = latch;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                                       + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
