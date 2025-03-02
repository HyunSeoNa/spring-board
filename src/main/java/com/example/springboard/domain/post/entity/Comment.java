package com.example.springboard.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

/**
 * fileName     : Comment.java
 * author       : hyunseo
 * date         : 2025. 3. 3.
 * description  : 댓글 Entity
 */
@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 500)
    private String content;
    //@ManyToOne(fetch = FetchType.LAZY)
    //private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    /*public Comment(String content, User author, Post post) {
        this.content = content;
        this.author = author;
        this.post = post;
    }*/
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public void update(String content) {
        this.content = content;
    }
}
