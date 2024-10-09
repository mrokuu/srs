package com.example.infrastructure.commands;

import com.example.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewCommandRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserIdAndCardId(Long id);
}
