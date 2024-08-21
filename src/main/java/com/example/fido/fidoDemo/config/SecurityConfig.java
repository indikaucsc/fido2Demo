package com.example.fido.fidoDemo.config;

//package com.example.fidoauth.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for the entire application
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/fido2/register", "/api/fido2/login").permitAll()  // Permit access to these endpoints
                        .anyRequest().authenticated()  // All other requests require authentication
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // In-memory user store with a single user for demo purposes
//        return new InMemoryUserDetailsManager(
//                User.withUsername("user")
//                        .password("{noop}password") // {noop} means no encoding, replace it with an encoder for production
//                        .roles("USER")
//                        .build()
//        );
//    }
//}
