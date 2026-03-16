package com.community.api.service;

import com.community.api.domain.Like;
import com.community.api.domain.LikeId;
import com.community.api.domain.Post;
import com.community.api.domain.User;
import com.community.api.repository.LikeRepository;
import com.community.api.repository.PostRepository;
import com.community.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void like(UUID postId, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        if (likeRepository.existsByUserIdAndPostId(user.getId(), postId)) {
            throw new IllegalArgumentException("이미 좋아요를 눌렀습니다.");
        }

        likeRepository.save(new Like(user, post));
        post.increaseLikeCount();
    }

    @Transactional
    public void unlike(UUID postId, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        if (!likeRepository.existsByUserIdAndPostId(user.getId(), postId)) {
            throw new IllegalArgumentException("좋아요를 누르지 않았습니다.");
        }

        likeRepository.deleteById(new LikeId(user.getId(), postId));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        post.decreaseLikeCount();
    }
}
