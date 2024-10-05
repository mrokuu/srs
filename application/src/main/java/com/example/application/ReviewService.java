package com.example.application;

import com.example.domain.entities.Review;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {


    private void calculateNextReview(Review review, int quality) {
        // SM-2 Algorithm implementation
        if (quality < 3) {
            review.setRepetition(0);
            review.setInterval(1);
        } else {
            int repetition = review.getRepetition() + 1;
            review.setRepetition(repetition);

            double easeFactor = review.getEaseFactor() + (0.1 - (5 - quality) * (0.08 + (5 - quality) * 0.02));
            if (easeFactor < 1.3) {
                easeFactor = 1.3;
            }
            review.setEaseFactor(easeFactor);

            int interval;
            if (repetition == 1) {
                interval = 1;
            } else if (repetition == 2) {
                interval = 6;
            } else {
                interval = (int) Math.round(review.getInterval() * review.getEaseFactor());
            }
            review.setInterval(interval);
        }

        // Set next review date
        LocalDateTime nextReviewDate = LocalDateTime.now().plusDays(review.getInterval());
        review.setNextReviewDate(nextReviewDate);
    }
}
