package ua.axiom.aggregator.model.persistance;

import javax.persistence.*;

@Entity
@Table(name = "auth_keys")
public class AuthKey {

    @Id
    @GeneratedValue
    private Long id;

    private String auth_key;

    public AuthKey() {
    }

    public AuthKey(String auth_key) {
        this.auth_key = auth_key;
    }
}
