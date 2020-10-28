import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private final int size;
    private final Object monitor = this;
    private final int DEFAULTSIZE = 1;

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    public SimpleBlockingQueue() {
        this.size = DEFAULTSIZE;
    }

    public synchronized void offer(T value) {
        while (queue.size() == size) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(value);
        monitor.notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
            monitor.wait();
        }
        monitor.notify();
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}


