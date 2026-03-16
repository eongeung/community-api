package com.community.api.repository;

import com.community.api.domain.Like;
import com.community.api.domain.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
    boolean existsByUserIdAndPostId(UUID userId, UUID postId);
}
