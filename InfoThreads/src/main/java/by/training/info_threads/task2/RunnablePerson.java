package by.training.info_threads.task2;

public class RunnablePerson extends Person implements Runnable {
    public RunnablePerson(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println("Hello, " + getName());
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnablePerson("Alice")).start();
        new Thread(new RunnablePerson("Bob")).start();
    }
}
