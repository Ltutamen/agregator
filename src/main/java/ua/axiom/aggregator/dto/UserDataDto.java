package ua.axiom.aggregator.dto;

/**
 * Transmits user data (username, locale, themes, etc) on the frontend
 */
public class UserDataDto {
    private String username;

    public UserDataDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
