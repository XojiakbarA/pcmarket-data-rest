package uz.pdp.pcmarketdatarest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                        .requestMatchers("/orders/**").hasAnyRole(Role.SUPER_ADMIN.name(), Role.OPERATOR.name())
                        .requestMatchers(HttpMethod.PUT, "/products/*").hasAnyRole(Role.SUPER_ADMIN.name(), Role.MODERATOR.name())
                        .requestMatchers(HttpMethod.DELETE, "/products/*").hasRole(Role.SUPER_ADMIN.name())

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return security.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails superAdmin = createSuperAdmin();
        UserDetails moderator = createModerator();
        UserDetails operator = createOperator();
        return new InMemoryUserDetailsManager(superAdmin, moderator, operator);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createSuperAdmin() {
        return User.builder()
                .username("super_admin")
                .password(passwordEncoder().encode("123"))
                .roles(Role.SUPER_ADMIN.name())
                .build();
    }
    private UserDetails createModerator() {
        return User.builder()
                .username("moderator")
                .password(passwordEncoder().encode("123"))
                .roles(Role.MODERATOR.name())
                .build();
    }
    private UserDetails createOperator() {
        return User.builder()
                .username("operator")
                .password(passwordEncoder().encode("123"))
                .roles(Role.OPERATOR.name())
                .build();
    }
}
