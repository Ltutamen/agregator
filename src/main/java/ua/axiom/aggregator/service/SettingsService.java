package ua.axiom.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.axiom.aggregator.model.persistance.AuthKeyDescription;
import ua.axiom.aggregator.repository.AuthKeyDescriptionRepository;

import java.util.Collection;

@Service
public class SettingsService {
    private final AuthKeyDescriptionRepository repository;

    @Autowired
    public SettingsService(AuthKeyDescriptionRepository repository) {
        this.repository = repository;
    }

    public Collection<AuthKeyDescription> getKeyDescriptionsForUser(Long userId) {
        return repository.findByUser_IdEquals(userId);
    }
}
