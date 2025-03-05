package com.example.springboard.domain.user.repository;

import com.example.springboard.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * fileName     : UserRepository.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : User Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
