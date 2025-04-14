package com.example.springboard.domain.board.repository;

import com.example.springboard.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 14.
 * description  :
 */
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
