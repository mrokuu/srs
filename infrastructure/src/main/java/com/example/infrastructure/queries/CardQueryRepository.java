package com.example.infrastructure.queries;

import com.example.domain.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardQueryRepository extends JpaRepository<Card,Long> {
    List<Card> findByDeckId(Long deckId);
}
