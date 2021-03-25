package ua.axiom.aggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.axiom.aggregator.model.persistance.AuthKeyDescription;

import java.util.Collection;

public interface AuthKeyDescriptionRepository extends JpaRepository<AuthKeyDescription, Long> {
    Collection<AuthKeyDescription> findByUser_IdEquals(Long id);

    Collection<AuthKeyDescription> findByUser_IdAndSiteName(Long id, String siteName);

}
