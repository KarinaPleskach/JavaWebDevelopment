package by.training.info_threads.task3;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
        System.out.println(mainThread.getPriority());
        System.out.println(mainThread.getThreadGroup().getName());
        System.out.println(mainThread);
    }
}
