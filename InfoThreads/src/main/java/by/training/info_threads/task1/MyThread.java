package by.training.info_threads.task1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello world!");
    }
    public static void main(String[] args) {
        new MyThread().start();
    }
}
