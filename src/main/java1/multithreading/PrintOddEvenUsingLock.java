package main.java1.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenUsingLock {
    public static void main(String[] args) {

        OddEvenImpl obj = new OddEvenImpl();

        Odd odd = new Odd(obj);
        Even even = new Even(obj);
        odd.start();

        /* *
         * Just starting 2nd thread after
         * a half second
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        even.start();
    }
}


class OddEvenImpl {
    private final Lock lock = new ReentrantLock();

    private final Condition oddCondition = lock.newCondition();

    private final Condition evenCondition = lock.newCondition();

    private int counter = 1;

    public void printOdd() throws InterruptedException {
        while (counter <= 10) {
            try {
                lock.lock();
                System.out.println("ODD :" + counter++);
                evenCondition.signal();
                if (counter < 10) {
                    oddCondition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() throws InterruptedException {
        while (counter <= 10) {
            try {
                // Getting lock for EVEN block
                lock.lock();
                System.out.println("EVEN : " + counter++);
                // signaling to ODD condition
                oddCondition.signal();
                /*
                 * Just stopping await once reach counter to 10.
                 * Not to even thread to await indefinitely
                 */
                if (counter < 10) {
                    evenCondition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

}

class Odd extends Thread {
    OddEvenImpl pc;

    public Odd(OddEvenImpl pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.printOdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Even extends Thread {
    OddEvenImpl pc;

    public Even(OddEvenImpl pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.printEven();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}