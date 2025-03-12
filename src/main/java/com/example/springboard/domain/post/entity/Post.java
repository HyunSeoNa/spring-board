package com.example.springboard.domain.post.entity;

import com.example.springboard.domain.comment.entity.Comment;
import com.example.springboard.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * fileName     : Post.java
 * author       : hyunseo
 * date         : 2025. 3. 2.
 * description  : 게시글 Entity
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
