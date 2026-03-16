package com.community.api.dto;

import com.community.api.domain.Post;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class PostResponse {
    private UUID id;
    private String title;
    private String content;
    private String author;
    private int likeCount;
    private LocalDateTime createdAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.isAnonymous() ? "익명" : post.getUser().getNickname();
        this.likeCount = post.getLikeCount();
        this.createdAt = post.getCreatedAt();
    }
}
