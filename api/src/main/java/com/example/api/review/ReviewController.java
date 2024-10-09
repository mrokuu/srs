package com.example.api.review;

import com.example.application.ReviewService;
import com.example.application.commands.ReviewCommandService;
import com.example.application.queries.ReviewQueryService;
import com.example.domain.entities.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping
    public ResponseEntity<Void> submitReview(
            @RequestBody Review reviewDTO) {

        reviewCommandService.submitReview(reviewDTO);

        return ResponseEntity.created(URI.create("/reviews/" + reviewDTO.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<Review>> getDueReviews(){

        List<Review> reviews = reviewQueryService.getDueReviews();

        return ResponseEntity.ok().build();
    }

}
