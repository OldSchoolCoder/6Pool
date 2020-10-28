import java.util.LinkedList;
import java.util.List;


public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public void init() {
        for (int i = 0; i < size; i++) {
            try {
                threads.add(new Thread(tasks.poll()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            threads.get(i).start();
        }
    }

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).interrupt();
        }
    }
}

