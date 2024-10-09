package com.example.infrastructure.queries;

import com.example.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewQueryRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserIdAndNextReviewDateBefore(LocalDateTime now);
}
