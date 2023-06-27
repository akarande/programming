package multithreading;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class Multithreading implements Runnable {
    private LinkedBlockingQueue<String> queue;
    void readElements() throws InterruptedException {
        while (!queue.isEmpty()) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is reading val => " + queue.poll());
        }
        Thread.currentThread().join();
    }
    @Override
    public void run() {
        try {
            readElements();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Multithreading multithreading = new Multithreading();
        multithreading.queue = new LinkedBlockingQueue<>();
        multithreading.queue.addAll(Arrays.asList("Calfornia", "Washington", "Colorado", "Montana", "New York", "Indiana", "Illinois", "Nevada", "Arizona", "Utah", "New Mexico"));
        int n = 3;
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(multithreading);
            thread.start();
        }
    }
}
