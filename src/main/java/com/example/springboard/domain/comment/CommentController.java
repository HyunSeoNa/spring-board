package com.example.springboard.domain.comment;

import com.example.springboard.domain.comment.repository.CommentRepository;
import com.example.springboard.global.response.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * fileName     : CommentController.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : Comment Controller
 */
@Tag(name = "Comment API", description = "댓글 API")
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @Operation(summary = "댓글 등록")
    @PostMapping
    public ResponseEntity<?> createComment(@RequestParam Long postId, @RequestParam String content, @RequestParam String userName) {
        return ResponseEntity.ok(ResponseDTO.success("댓글 등록 성공.", commentService.createComment(postId, content, userName)));
    }

    @Operation(summary = "특정 게시글 댓글 조회")
    @GetMapping("/{postId}")
    public ResponseEntity<?> getCommentByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(ResponseDTO.success("댓글 조회 성공.", commentService.getCommentsByPost(postId)));
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(ResponseDTO.success("댓글 삭제 성공"));
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestParam String content) {
        return ResponseEntity.ok(ResponseDTO.success("댓글 수정 성공", commentService.updateComment(commentId, content)));
    }
}
