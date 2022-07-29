package main.java1.multithreading;

public class HappenBeforerelationShip {
    private int counter;

    private synchronized void incrementCounter() {
        for (int i = 0; i < 2000; i++) {
            counter++;
        }
    }

    private synchronized int getCounter() {
        return counter;
    }

    public void trigger() {
        Thread t1 = new Thread(() -> incrementCounter());
        Thread t2 = new Thread(() -> System.out.println("Current couter value = " + getCounter()));

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        HappenBeforerelationShip obj = new HappenBeforerelationShip();
        obj.trigger();
    }
}
