package com.example.application.commands;

import com.example.domain.entities.Card;
import com.example.domain.entities.Review;
import com.example.infrastructure.commands.CardCommandRepository;
import com.example.infrastructure.commands.ReviewCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {

    private final ReviewCommandRepository reviewCommandRepository;
    private final CardCommandRepository cardCommandRepository;

    public void submitReview(Review review) {
        Card card = cardCommandRepository.findById(review.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));


        Review reviewResult = reviewCommandRepository.findByUserIdAndCardId(review.getId())
                .orElse(new Review());


        reviewResult.setCard(card);

//        updateReviewParameters(review, reviewResult.ge());

        reviewCommandRepository.save(review);
    }


    private void updateReviewParameters(Review review, int quality) {
        // SM-2 Algorithm implementation
        if (quality < 3) {
            review.setRepetition(0);
            review.setInterval(1);
        } else {
            int repetition = review.getRepetition() + 1;
            review.setRepetition(repetition);

            double easeFactor = review.getEaseFactor() + (0.1 - (5 - quality) * (0.08 + (5 - quality) * 0.02));
            easeFactor = Math.max(easeFactor, 1.3);
            review.setEaseFactor(easeFactor);

            int interval;
            if (repetition == 1) {
                interval = 1;
            } else if (repetition == 2) {
                interval = 6;
            } else {
                interval = (int) Math.round(review.getInterval() * easeFactor);
            }
            review.setInterval(interval);
        }

        review.setNextReviewDate(LocalDateTime.now().plusDays(review.getInterval()));
    }
}
