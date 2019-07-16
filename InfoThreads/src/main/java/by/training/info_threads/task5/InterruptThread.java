package by.training.info_threads.task5;

public class InterruptThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Working");
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            System.out.println("!Working");
        });
        thread.start();
        thread.interrupt();
    }
}
