import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    private String subject;
    private String body;
    private String email;

    public void emailTo(final User user) {
        pool.submit(() -> {
            subject = "Notification " + user.getUsername() + " to email " + user.getEmail();
            body = "Add a new event to " + user.getUsername();
            email = user.getEmail();
            send(subject, body, email);
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
