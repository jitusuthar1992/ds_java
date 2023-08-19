package main.java1.multithreading;

public class ThreadJoiningInterrupt {

    public static void main(String[] args) {

        ChildThread childThread = new ChildThread(Thread.currentThread());
        childThread.start();

        try {

            childThread.join();   //Joined

        } catch (InterruptedException ie) {
            System.out.println("main Thread is interrupted");
        }

        for (int i = 1; i <= 4; i++) {
            System.out.println("main Thread Execution - " + i);
        }
    }
}

    class ChildThread extends Thread {

        private static Thread parentThreadRef;

        public ChildThread(Thread parentThreadRef) {
            this.parentThreadRef = parentThreadRef;
        }

        public void run() {

            parentThreadRef.interrupt();   //Interrupted

            for (int i = 1; i <= 4; i++) {
                System.out.println("Child Thread Execution - " + i);
            }
        }
}
