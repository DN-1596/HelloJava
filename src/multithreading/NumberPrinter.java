package multithreading;

public class NumberPrinter implements Runnable {

    private int num;

    NumberPrinter(int num) {
        this.num = num;
    }


    @Override
    public void run() {
        System.out.println("IN THREAD -- "+Thread.currentThread().getName() + " PRINTING -- "+num);
    }
}
