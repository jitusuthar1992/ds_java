package main.java1.thread.pool;

import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private String name;


    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Long duration = 10000l;
            System.out.println("Executing : " + name);
            TimeUnit.MILLISECONDS.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
