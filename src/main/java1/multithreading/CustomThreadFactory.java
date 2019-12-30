package main.java1.multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author jitendra.kumar01
 * 29/12/19
 */
public class CustomThreadFactory implements ThreadFactory {
    private int          counter;
    private String       name;
    private List<String> stats;

    public CustomThreadFactory(String name)
    {
        counter = 1;
        this.name = name;
        stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
        return t;
    }
    public String getStats()
    {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while (it.hasNext())
        {
            buffer.append(it.next());
        }
        return buffer.toString();
    }


    public static void main(String[] args)
    {
        CustomThreadFactory factory = new CustomThreadFactory("CustomThreadFactory");
        Task1 task = new Task1();
        Thread thread;
        System.out.printf("Starting the Threads\n\n");
        for (int i = 1; i <= 10; i++)
        {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.printf("All Threads are created now\n\n");
        System.out.printf("Give me CustomThreadFactory stats:\n\n" + factory.getStats());
    }
}

class Task1 implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

