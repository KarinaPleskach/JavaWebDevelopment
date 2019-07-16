package by.training.info_threads.task3_;

public class SimpleThread extends Thread {
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("старт потока-демона");
                Thread.sleep(10_000);
            } else {
                System.out.println("старт обычного потока");
            }
        } catch (InterruptedException e) {
            System.err.print(e);
        } finally {
            if (!isDaemon()) {
                System.out.println("завершение обычного потока");
            } else {
                System.out.println("завершение потока-демона");
            }
        }
    }

    public static void main(String[ ] args) {
        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();
        System.out.println("последний оператор main");
    }
}
