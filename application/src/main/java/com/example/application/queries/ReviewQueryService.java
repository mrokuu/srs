package com.example.application.queries;

import com.example.domain.entities.Review;
import com.example.infrastructure.queries.ReviewQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewQueryRepository reviewQueryRepository;

    public List<Review> getDueReviews() {
        return reviewQueryRepository.findByUserIdAndNextReviewDateBefore(LocalDateTime.now());
    }
}
