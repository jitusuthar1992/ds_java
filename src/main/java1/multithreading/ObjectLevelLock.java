package main.java1.multithreading;

/**
 * @author jitendra.kumar01
 * 24/12/19
 */
public class ObjectLevelLock {
    public synchronized void demoMethod(){

    }

    public  void demoMethod1(){
        synchronized (this){

        }
    }

    private final Object lock = new Object();
    public void demoMethod3(){
        synchronized (lock)
        {
            //other thread safe code
        }
    }
}
