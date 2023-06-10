package multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberGenerator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return  new Random().nextInt(50);
    }
}
