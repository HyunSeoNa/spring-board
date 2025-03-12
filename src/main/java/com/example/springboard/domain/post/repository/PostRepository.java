package com.example.springboard.domain.post.repository;

import com.example.springboard.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName     : PostRepository.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : Post Repository
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
