package main.java1.multithreading;

import java.io.File;
import java.net.MalformedURLException;

public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) {
        File f = new File("/opt/score/jobs/sca-simulation/pending/SCASimulationTemplate (3).csv");
        try {
            System.out.println(f.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
