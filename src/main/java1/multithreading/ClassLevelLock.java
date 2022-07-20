package main.java1.multithreading;

/**
 * @author jitendra.kumar01
 * 24/12/19
 */
public class ClassLevelLock {
    public synchronized static void demoMethod() {

    }

    public void demoMethod1() {
        synchronized (ClassLevelLock.class) {

        }
    }

    private final static Object lock = null;

    public void demoMethod3() {
        synchronized (lock)//null pointer Exception
        {
            //other thread safe code
        }
    }
}
