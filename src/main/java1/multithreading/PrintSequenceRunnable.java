package main.java1.multithreading;


public class PrintSequenceRunnable implements Runnable {
    public static int PRINT_NUMBERS_UPTO = 10;
    static volatile int number = 1;
    int remainder;
    //static Object lock=new Object();

    static Object lock = new Object();
    //private Condition notFull = lock.newCondition();

    public PrintSequenceRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number <= PRINT_NUMBERS_UPTO) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(number % 3 == remainder && number <= PRINT_NUMBERS_UPTO){
                    System.out.println(Thread.currentThread().getName() + " " + number);

                }
                number++;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");
        Thread t3 = new Thread(runnable3, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
