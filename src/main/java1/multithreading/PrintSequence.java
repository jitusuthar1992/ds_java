package main.java1.multithreading;

public class PrintSequence implements Runnable{

    private static final int MAX =10 ;
    private static volatile int  number = 1;
    private int remainder;

    private static final Object lock = new Object();

    public PrintSequence(int remainder) {
        this.remainder = remainder;
    }


    @Override
    public void run() {
        while (number < MAX-1){
            synchronized (lock){
                while (number % 3 != remainder){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


                System.out.println(Thread.currentThread().getName() + " " + number++);
                lock.notifyAll();


            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintSequence(1), "T1"); // 1 represents Thread-1 remainder
        Thread t2 = new Thread(new PrintSequence(2), "T2"); // 2 represents Thread-2 remainder
        Thread t3 = new Thread(new PrintSequence(0), "T3"); // 0 represents Thread-3 remainder
        t1.start();
        t2.start();
        t3.start();
    }
}
