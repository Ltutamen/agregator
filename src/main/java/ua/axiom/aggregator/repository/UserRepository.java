package ua.axiom.aggregator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.axiom.aggregator.model.persistance.User;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);
}
