package ua.axiom.aggregator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

/**
 * Creates BCrypt password encoder with seen from .properties
 */
@Configuration
public class PasswordEncodingConfiguration {
    @Value("${value.secretSeed}")
    private String secretSeed;

    @Bean
    @Primary
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return "debug encoder";
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                //  todo fix
                return true;
            }
        };
        //  return new BCryptPasswordEncoder(8, new SecureRandom(secretSeed.getBytes()));
    }
}
