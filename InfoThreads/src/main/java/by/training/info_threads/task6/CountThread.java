package by.training.info_threads.task6;

public class CountThread implements Runnable {

    CommonResource resource;

    public CountThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.increment();
    }
}
