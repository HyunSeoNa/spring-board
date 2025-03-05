package com.example.springboard.domain.comment.repository;

import com.example.springboard.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  :
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
