package main.java1.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jitendra.kumar01
 * 18/12/19
 */
public class CyclicBarrierDemo extends Thread {

    public static CyclicBarrier barrier = new CyclicBarrier(3);

    @Override
    public void run() {

        System.out.println("Number of parties required to trip the barrier = " +
                barrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation2.product +
                Computation1.sum));

        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();

        comp1.start();
        comp2.start();

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of product and sum = " + (Computation1.sum +
                Computation2.product));

        // Resetting the newBarrier
        barrier.reset();
        System.out.println("Barrier reset successful");

    }

    public static void main(String[] args) {
        CyclicBarrierDemo test = new CyclicBarrierDemo();

        Thread t1 = new Thread(test);
        t1.start();
    }
}

class Computation1 extends Thread {

    public static int sum = 0;

    @Override
    public void run() {

        System.out.println("Is the barrier broken? - " + CyclicBarrierDemo.barrier.isBroken());
        sum = 10 + 20;

        try {
            CyclicBarrierDemo.barrier.await();
            System.out.println("Number of parties waiting at the barrier " +
                    "at this point = " + CyclicBarrierDemo.barrier.getNumberWaiting());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Computation2 extends Thread {
    public static int product = 0;

    public void run() {
        product = 2 * 3;
        try {
            CyclicBarrierDemo.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
