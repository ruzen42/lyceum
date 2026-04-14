package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class DataInitService implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.existsByUsername("admin")) {
            return;
        }

        User user = User.builder()
                .username("admin")
                .email("vakin83@list.ru")
                .password(passwordEncoder.encode("19283746"))
                .roles(Set.of(Role.ROLE_ADMIN))
                .build();

        userRepository.save(user);
    }
}
