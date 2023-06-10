package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadingIntro {

    /**
     * print Hello World from a different thread than main thread
     */
/*
     public static void main(String[] args) {
        System.out.println("IN THREAD -- "+Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        helloWorldPrinter.run();

        Thread t = new Thread(helloWorldPrinter);
        t.start();
        // second trigger gives IllegalThreadStateException
        // t.start();
    }
 */


    /**
     * print 1 to 100 and all of them through different threads
     */
/*

    public static void main(String[] args) {
        System.out.println("IN THREAD -- "+Thread.currentThread().getName());
        for (int i=1;i<=100;i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }
    }
*/

    /**
     * Move the above code to executor framework
     */
/*
    public static void main(String[] args) {
        System.out.println("IN THREAD -- "+Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=1;i<=100;i++) {
            NumberPrinter np = new NumberPrinter(i);
            if (i == 50) {
                System.out.println("DEBUG POINTER HERE");
            }
            executorService.execute(np);
        }
    }*/

    /**
     * Generate 2 random numbers and add them and these random no. should be generated in separate threads.
     * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        RandomNumberGenerator gen1 = new RandomNumberGenerator();
        RandomNumberGenerator gen2 = new RandomNumberGenerator();

        Future<Integer> random1 = executorService.submit(gen1);
        Future<Integer> random2 = executorService.submit(gen2);

        int val1 = random1.get();
        int val2 = random2.get();

        System.out.println("SUM of random numbers : " + val1 + " + " + val2 + " = " + (val1+val2));
    }



}

