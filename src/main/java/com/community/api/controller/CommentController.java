package com.community.api.controller;

import com.community.api.dto.CommentRequest;
import com.community.api.dto.CommentResponse;
import com.community.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/posts/{postId}/comments")
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable UUID postId,
            @AuthenticationPrincipal String email,
            @RequestBody CommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(postId, email, request));
    }

    @GetMapping("/api/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable UUID postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    @DeleteMapping("/api/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable UUID commentId,
            @AuthenticationPrincipal String email) {
        commentService.deleteComment(commentId, email);
        return ResponseEntity.noContent().build();
    }
}
