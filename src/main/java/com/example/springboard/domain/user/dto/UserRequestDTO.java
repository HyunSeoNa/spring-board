package com.example.springboard.domain.user.dto;

import lombok.Data;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
@Data
public class UserRequestDTO {
    private String username;
    private String password;
    private String nickname;
}
