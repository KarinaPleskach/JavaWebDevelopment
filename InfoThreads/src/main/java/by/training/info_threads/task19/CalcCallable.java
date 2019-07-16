package by.training.info_threads.task19;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Number> {
    @Override
    public Number call() throws Exception {
        Number res = new Random().nextGaussian(); // имитация вычислений
        return res;
    }
}
