package ua.axiom.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.axiom.aggregator.dto.RegisterFormDto;
import ua.axiom.aggregator.model.exception.NotUniqueUsernameOrEmailException;
import ua.axiom.aggregator.model.persistance.User;
import ua.axiom.aggregator.repository.UserRepository;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //  todo isolation levels
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackForClassName = "UserAlreadyExistsException")
    public void register(RegisterFormDto dto) {

        if(userRepository.existsByUsernameOrEmail(dto.username, dto.email)) {
            throw new NotUniqueUsernameOrEmailException(dto.username, dto.email);
        }

        User user = new User(dto.username, passwordEncoder.encode(dto.password), dto.email);

        userRepository.save(user);
    }
}
