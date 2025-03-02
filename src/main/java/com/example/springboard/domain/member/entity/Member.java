package com.example.springboard.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * fileName     : Member.java
 * author       : hyunseo
 * date         : 2025. 3. 3.
 * description  : Member Entity
 */
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    Long id;

}
