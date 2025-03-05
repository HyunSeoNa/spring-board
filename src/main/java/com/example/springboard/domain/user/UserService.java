package com.example.springboard.domain.user;

import com.example.springboard.domain.user.entity.User;
import com.example.springboard.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

    public User register(String userName, String password) {
        return userRepository.save(new User(userName, password));
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
