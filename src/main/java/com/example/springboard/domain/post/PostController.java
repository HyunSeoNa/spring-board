package com.example.springboard.domain.post;

import com.example.springboard.global.response.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * fileName     : PostController.java
 * author       : hyunseo
 * date         : 2025. 3. 2.
 * description  : 게시글 Controller
 */
@Tag(name = "Post API", description = "게시글 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @Operation(summary = "게시글 등록")
    public ResponseEntity<?> createPost(@RequestParam String title, @RequestParam String content, @RequestParam String userName) {
        return ResponseEntity.ok(ResponseDTO.success("게시글 등록 성공.", postService.creatPost(title, content, userName)));
    }

    @GetMapping
    @Operation(summary = "게시글 목록 조회")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(ResponseDTO.success("게시글 목록 조회 성공.", postService.getListPost()));
    }

    @DeleteMapping("/{postId}")
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(ResponseDTO.success("게시글 삭제 성공"));
    }
}
