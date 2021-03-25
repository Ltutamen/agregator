package ua.axiom.aggregator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String[] GUEST_ENDPOINTS = new String[]{"/", "/index", "/login", "/auth", "/register"};
    private static final String[] USER_ENDPOINTS = new String[]{"/feed**", "/settings**", "/api**"};
    private static final String[] ADMIN_ENDPOINTS = new String[]{"/admin**"};

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(GUEST_ENDPOINTS)
                        .permitAll()
                    .antMatchers(USER_ENDPOINTS)
                        .hasAuthority("ROLE_USER")
                    .antMatchers(ADMIN_ENDPOINTS)
                        .hasAuthority("ROLE_ADMIN")
                    .antMatchers( "/resources/static/**", "/static/**", "/html/**")
                        .permitAll()
                    .and()
                        .formLogin()
                            .loginPage("/login")
                            //  .loginProcessingUrl("/auth")
                            .successForwardUrl("/redirect")
                            .passwordParameter("password")
                            .usernameParameter("username")
//                            .failureForwardUrl("/login?error=true")
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .permitAll()
                    .and()
                        .csrf()
                            .disable() //  todo enable
                    .userDetailsService(userDetailsService);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
// .and()
//         .formLogin()
//         .loginProcessingUrl("/auth")
//         .passwordParameter("password")
//         .usernameParameter("username")
//         .failureForwardUrl("/login?error=true")
//         .successForwardUrl("/redirect")
//         .and()