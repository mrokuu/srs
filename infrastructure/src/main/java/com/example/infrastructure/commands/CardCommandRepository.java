package com.example.infrastructure.commands;

import com.example.domain.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardCommandRepository extends JpaRepository<Card,Long> {
}
