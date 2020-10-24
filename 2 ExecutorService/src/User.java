public class User {
    private final String username;
    private final String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public User(final String username, final String email) {
        this.username = username;
        this.email = email;
    }
}
