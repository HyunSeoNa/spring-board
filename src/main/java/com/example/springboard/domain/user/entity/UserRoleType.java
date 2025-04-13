package com.example.springboard.domain.user.entity;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
public enum UserRoleType {
    ADMIN("어드민"),
    USER("유저");

    private final String description;

    UserRoleType(String description) {
        this.description = description;
    }
}
