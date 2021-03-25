package ua.axiom.aggregator.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.axiom.aggregator.model.exception.WrongCredentialsException;
import ua.axiom.aggregator.model.persistance.AuthKey;
import ua.axiom.aggregator.model.persistance.User;
import ua.axiom.aggregator.repository.UserRepository;
import ua.axiom.aggregator.model.persistance.AuthKeyDescription;
import ua.axiom.aggregator.repository.AuthKeyDescriptionRepository;
import ua.axiom.aggregator.repository.AuthKeysRepository;

import java.util.Collection;

@Service
public class KeyPersistenceService {
    private final AuthKeyDescriptionRepository keyDescriptionRepository;
    private final UserRepository userRepository;
    private final AuthKeysRepository keysRepository;

    public KeyPersistenceService(
            AuthKeyDescriptionRepository keyDescriptionRepository,
            AuthKeysRepository keysRepository,
            UserRepository userRepository
    ) {
        this.keyDescriptionRepository = keyDescriptionRepository;
        this.keysRepository = keysRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addKey(String key, String forUserName, String siteName) {
        AuthKey authKey = new AuthKey(key);
        User user = userRepository.findByUsername(forUserName).orElseThrow(WrongCredentialsException::new);

        AuthKeyDescription description = new AuthKeyDescription(user, siteName, authKey);
        keyDescriptionRepository.save(description);
    }

    public Collection<AuthKeyDescription> getKeyDescriptionsForUsername(String username) {
        Long userId = userRepository.findByUsername(username).orElseThrow(RuntimeException::new).getId();

        return keyDescriptionRepository.findByUser_IdEquals(userId);
    }
}
