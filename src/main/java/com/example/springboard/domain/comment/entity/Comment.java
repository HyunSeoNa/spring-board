package com.example.springboard.domain.comment.entity;

import com.example.springboard.domain.post.entity.Post;
import com.example.springboard.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * fileName     : Comment.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : Comment Entity
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private User author;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Comment parent;
}
