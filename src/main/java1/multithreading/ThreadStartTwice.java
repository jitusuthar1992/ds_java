package main.java1.multithreading;

/**
 * @author jitendra.kumar01
 * 22/02/20
 */
public class ThreadStartTwice {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task("task");
        Thread t1 = new Thread(task);
        t1.start();
        t1.start();
    }
}

/*
 Once you have started a thread, it can not be started again.
If you try to start thread again , it will throw IllegalThreadStateException
 */