package main.java1.multithreading;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author jitendra.kumar01
 * 29/12/19
 */
public class PiperStreamInterThreadComm {
    public static void main(String[] args) {
        try
        {
            // Create writer and reader instances
            PipedReader pr = new PipedReader();
            PipedWriter pw = new PipedWriter();

            // Connect the writer with reader
            pw.connect(pr);

            // Create one writer thread and one reader thread
            Thread thread1 = new Thread(new PipedReaderThread(pr,"ReaderThread"));

            Thread thread2 = new Thread(new PipedWriterThread(pw,"WriterThread" ));

            // start both threads
            thread1.start();
            thread2.start();

        }
        catch (Exception e)
        {
            System.out.println("PipeThread Exception: " + e);
        }
    }
}

class PipedReaderThread implements Runnable{

    PipedReader pr = null;
    String name ;

    public PipedReaderThread(PipedReader pr, String name) {
        this.pr = pr;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                char c = (char) pr.read();
                if(c != -1){
                    System.out.print(c);
                }
            } catch (Exception e) {
                System.out.println(" PipeThread Exception: " + e);
            }
        }
    }
}

class PipedWriterThread implements Runnable{

    PipedWriter pw = null;
    String      name ;

    public PipedWriterThread(PipedWriter pw, String name) {
        this.pw = pw;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                pw.write("Testing data written...n");
                pw.flush();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(" PipeThread Exception: " + e);
            }
        }
    }
}

