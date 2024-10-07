package com.example.application.queries;

import com.example.domain.entities.Card;
import com.example.infrastructure.queries.CardQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardQueryService {

    private final CardQueryRepository cardQueryRepository;

    public List<Card> getCardsByDeckId(Long deckId) {
        return cardQueryRepository.findByDeckId(deckId);
    }
}
