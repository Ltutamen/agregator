package ua.axiom.aggregator.model.persistance;


import javax.persistence.*;

@Entity
@Table(name = "auth_keys_descriptions")
public class AuthKeyDescription {

    public AuthKeyDescription(User user, String siteName, AuthKey key) {
        this.user = user;
        this.siteName = siteName;
        this.auth_key = key;
    }

    public AuthKeyDescription() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String siteName;

    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private AuthKey auth_key;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getSiteName() {
        return siteName;
    }

    public AuthKey getAuth_key() {
        return auth_key;
    }
}
