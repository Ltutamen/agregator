package ua.axiom.aggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.axiom.aggregator.model.persistance.AuthKey;

public interface AuthKeysRepository extends JpaRepository<AuthKey, Long> {
}
