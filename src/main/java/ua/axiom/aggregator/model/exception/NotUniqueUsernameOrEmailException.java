package ua.axiom.aggregator.model.exception;

public class NotUniqueUsernameOrEmailException extends LightweightRuntimeException {
    private final String username;
    private final String email;

    public NotUniqueUsernameOrEmailException(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
