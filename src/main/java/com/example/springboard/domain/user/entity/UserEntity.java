package com.example.springboard.domain.user.entity;

import com.example.springboard.domain.board.entity.BoardEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)    // Enum 타입을 저장하면 기본적으로 숫자 0, 1 형태로 저장됨 -> ADMIN, USER 형태로 저장하기 위해 설정.
    private UserRoleType role;

    @OneToMany(mappedBy = "userEntity", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    // 유저에 대해 새로운 글을 추가할 때 : 추가할 글을 받아서 연관관계에 매핑해줌
    public void addBoardEntity(BoardEntity entity) {
        entity.setUserEntity(this);
        boardEntityList.add(entity);
    }

    // 유저에 대해 기존 글을 삭제할 때 : 삭제할 글을 받아서 연관관계에서 뻄
    public void removeBoardEntity(BoardEntity entity) {
        entity.setUserEntity(null);
        this.boardEntityList.remove(entity);
    }
}
