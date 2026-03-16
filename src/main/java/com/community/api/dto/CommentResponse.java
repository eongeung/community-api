package com.community.api.dto;

import com.community.api.domain.Comment;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CommentResponse {
    private UUID id;
    private String content;
    private String author;
    private UUID parentId;
    private LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.author = comment.isAnonymous() ? "익명" : comment.getUser().getNickname();
        this.parentId = comment.getParent() != null ? comment.getParent().getId() : null;
        this.createdAt = comment.getCreatedAt();
    }
}
