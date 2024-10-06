package com.example.infrastructure.commands;

import com.example.domain.entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckCommandRepository extends JpaRepository<Deck,Long> {
}
