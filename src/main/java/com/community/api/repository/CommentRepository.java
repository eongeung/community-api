package com.community.api.repository;

import com.community.api.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByPostIdAndParentIsNullOrderByCreatedAtAsc(UUID postId);
    List<Comment> findByParentIdOrderByCreatedAtAsc(UUID parentId);
}
