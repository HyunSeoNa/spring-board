package com.example.springboard.domain.user.entity;

import jakarta.persistence.*;
import lombok.Data;

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

}
