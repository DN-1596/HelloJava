package multithreading;


public class HelloWorldPrinter implements Runnable {

    @Override
    public void run() {
        System.out.println("IN THREAD -- "+Thread.currentThread().getName());
        System.out.println("Hello World");
    }
}
