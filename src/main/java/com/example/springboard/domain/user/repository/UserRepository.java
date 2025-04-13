package com.example.springboard.domain.user.repository;

import com.example.springboard.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
