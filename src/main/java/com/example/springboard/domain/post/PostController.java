package com.example.springboard.domain.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName     : PostController.java
 * author       : hyunseo
 * date         : 2025. 3. 2.
 * description  : 게시글 Controller
 */
@Tag(name = "Post API", description = "게시글 API")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @GetMapping
    @Operation(summary = "전체 게시글 조회")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(null);
    }
}
