package ua.axiom.aggregator.model.persistance;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.axiom.aggregator.model.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "users")
public class User implements UserDetails {
    private static final Collection<? extends GrantedAuthority> authorities = Collections.unmodifiableSet(Collections.singleton(Role.ROLE_USER));

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_generator", sequenceName = "users_generator_sequence")
    private Long id;

    private String username;

    private String password;

    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }
}
