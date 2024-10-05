package com.example.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant nextReviewDate;

    private double easeFactor = 2.5;

    private int interval; // in days

    private int repetition;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
