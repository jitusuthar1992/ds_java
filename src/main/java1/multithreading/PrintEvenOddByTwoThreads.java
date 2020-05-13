package main.java1.multithreading;

public class PrintEvenOddByTwoThreads implements Runnable {


    private final int MAX = 20;
    private static  int number =1;
    private int remainder;

    static Object object = new Object();

    public PrintEvenOddByTwoThreads(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < MAX){
            synchronized (object){
                while (number %2 != remainder) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println(Thread.currentThread().getName() + " "+number);
            number++;
            object.notify();
            }
        }
    }


    public static void main(String[] args) {
        Thread evenThread = new Thread(new PrintEvenOddByTwoThreads(0),"even");
        Thread oddThread = new Thread(new PrintEvenOddByTwoThreads(1),"odd");

        evenThread.start();
        oddThread.start();

    }
}
