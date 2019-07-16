package by.training.info_threads.task4;

public class YieldRunner {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("старт потока 1");
                Thread.yield();
                System.out.println("завершение 1");
            }
        }.start();
        new Thread() {
            public void run() {
                System.out.println("старт потока 2");
                System.out.println("завершение 2");
            }
        }.start();
    }
}
