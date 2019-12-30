package main.java1.multithreading;

/**
 * @author jitendra.kumar01
 * 24/12/19
 */


/*Yield is a Static method and Native too.
Yield tells the currently executing thread to give a chance to the threads that have equal priority in the Thread Pool.
There is no guarantee that Yield will make the currently executing thread to runnable state immediately.
It can only make a thread from Running State to Runnable State, not in wait or blocked state.*/
public class TestYield {
    public static void main(String[] args)
    {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
