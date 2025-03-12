package com.example.springboard.domain.user;

import com.example.springboard.domain.user.entity.User;
import com.example.springboard.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * fileName     : UserService.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : UserService
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User addUser(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role("USER")
                .build();
        return userRepository.save(user);
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
