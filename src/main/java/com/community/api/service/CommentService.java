package com.community.api.service;

import com.community.api.domain.Comment;
import com.community.api.domain.Post;
import com.community.api.domain.User;
import com.community.api.dto.CommentRequest;
import com.community.api.dto.CommentResponse;
import com.community.api.repository.CommentRepository;
import com.community.api.repository.PostRepository;
import com.community.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentResponse createComment(UUID postId, String email, CommentRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        Comment parent = null;
        if (request.getParentId() != null) {
            parent = commentRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("부모 댓글을 찾을 수 없습니다."));
        }

        Comment comment = new Comment(post, user, parent, request.getContent(), request.isAnonymous());
        commentRepository.save(comment);

        return new CommentResponse(comment);
    }

    public List<CommentResponse> getComments(UUID postId) {
        return commentRepository.findByPostIdAndParentIsNullOrderByCreatedAtAsc(postId)
                .stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    public void deleteComment(UUID commentId, String email) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

        if (!comment.getUser().getEmail().equals(email)) {
            throw new IllegalArgumentException("삭제 권한이 없습니다.");
        }

        commentRepository.delete(comment);
    }
}
