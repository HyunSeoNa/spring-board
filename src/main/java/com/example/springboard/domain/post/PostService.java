package com.example.springboard.domain.post;

import com.example.springboard.domain.post.entity.Post;
import com.example.springboard.domain.post.repository.PostRepository;
import com.example.springboard.domain.user.entity.User;
import com.example.springboard.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * fileName     : PostService.java
 * author       : hyunseo
 * date         : 2025. 3. 2.
 * description  : Post Service
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post creatPost(String title, String content, String userName) {
        User author = userRepository.findByUserName(userName)
                .orElseThrow(()-> new RuntimeException("User not found"));
        return postRepository.save(new Post(title, content, author));
    }

    public List<Post> getListPost() {
        return postRepository.findAll();
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
