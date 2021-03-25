package ua.axiom.aggregator.dto;

import javax.validation.constraints.*;

public class RegisterFormDto {

    @NotEmpty
    @Pattern(regexp = "([\\w]){6,40}")
    @Size(min = 6, max = 40)
    public String username;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    @Pattern(regexp = "([\\w\\d]){8,40}")
    public String password;


    public RegisterFormDto() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
