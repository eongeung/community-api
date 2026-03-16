package com.community.api.controller;

import com.community.api.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts/{postId}/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Void> like(
            @PathVariable UUID postId,
            @AuthenticationPrincipal String email) {
        likeService.like(postId, email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> unlike(
            @PathVariable UUID postId,
            @AuthenticationPrincipal String email) {
        likeService.unlike(postId, email);
        return ResponseEntity.noContent().build();
    }
}
