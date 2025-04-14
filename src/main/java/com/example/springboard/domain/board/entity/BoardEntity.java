package com.example.springboard.domain.board.entity;

import com.example.springboard.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 14.
 * description  :
 */
@Data
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // varchar(256)

    @Column(columnDefinition = "TEXT")  // 길이가 긴 내용 저장.
    private String content;

    @ManyToOne // 1:N
    private UserEntity userEntity;
}
