package com.community.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentRequest {
    private String content;
    private boolean anonymous = true;
    private UUID parentId;
}
