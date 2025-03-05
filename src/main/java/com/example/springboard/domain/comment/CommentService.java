package com.example.springboard.domain.comment;

import com.example.springboard.domain.comment.entity.Comment;
import com.example.springboard.domain.comment.repository.CommentRepository;
import com.example.springboard.domain.post.entity.Post;
import com.example.springboard.domain.post.repository.PostRepository;
import com.example.springboard.domain.user.entity.User;
import com.example.springboard.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * fileName     : CommentService.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  :
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    /**
     * 댓글 작성
     * @param postId
     * @param content
     * @param userName
     * @return
     */
    public Comment createComment(Long postId, String content, String userName) {
        User author = userRepository.findByUserName(userName)
                .orElseThrow(()-> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("Post not found"));

        return commentRepository.save(new Comment(content, post, author));
    }

    /**
     * 특정 게시글의 댓글 조회
     * @param postId
     * @return
     */
    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    /**
     * 댓글 삭제
     * @param commentId
     */
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(Long commentId, String content) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new RuntimeException("Comment not found"));
        comment.update(content);

        return comment;
    }
}
