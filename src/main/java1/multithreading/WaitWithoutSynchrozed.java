package main.java1.multithreading;


/**
 * @author jitendra.kumar01
 * 17/12/19
 */
public class WaitWithoutSynchrozed implements Runnable {
    @Override
    public void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitWithoutSynchrozed obj = new WaitWithoutSynchrozed();
        Thread t = new Thread(obj);
        t.start();
    }
}
