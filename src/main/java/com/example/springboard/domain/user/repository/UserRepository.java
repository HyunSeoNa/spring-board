package com.example.springboard.domain.user.repository;

import com.example.springboard.domain.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);
    Optional<UserEntity> findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
