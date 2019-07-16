package by.training.info_threads.task3;

public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 50; ++i) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1); 
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }

    public static void main(String[ ] args) {
        PriorThread min = new PriorThread("Min");
        PriorThread max = new PriorThread("Max");
        PriorThread norm = new PriorThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();
    }
}
