package main.java1.multithreading;


import java.util.List;
import java.util.concurrent.*;

/**
 * @author jitendra.kumar01
 * 24/12/19
 */
public class FutureCallableTest {

    public static void main(String[] args)  {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Long> future = service.submit(new FactorialService(5));

        //future.cancel(true);
        System.out.println(future.isCancelled());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        service.shutdown();
        //List<Runnable> list =  service.shutdownNow();

        System.out.println();
        try {
            service.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class FactorialService implements Callable<Long> {
        private int number;

        public FactorialService(int number) {
            this.number = number;
        }

        @Override
        public Long call() throws Exception {
            return factorial();
        }

        private Long factorial() throws InterruptedException {
            long result = 1;
            Thread.sleep(5000);

            while (number != 0) {
                result = number * result;
                number--;
                Thread.sleep(100);
            }
            return result;
        }
    }
}


