import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class EmailNotification {
    private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(final User user) {
        AtomicReference<String> subject = new AtomicReference<>();
        AtomicReference<String> body = new AtomicReference<>();
        AtomicReference<String> email = new AtomicReference<>();
        pool.submit(() -> {
            subject.set("Notification " + user.getUsername() + " to email " + user.getEmail());
            body.set("Add a new event to " + user.getUsername());
            email.set(user.getEmail());
            send(subject.get(), body.get(), email.get());
        });
    }

    public void send(final String subject, final String body, final String email) {
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
