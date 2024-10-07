package com.example.application.commands;

import com.example.domain.entities.Card;
import com.example.domain.entities.Deck;
import com.example.infrastructure.commands.CardCommandRepository;
import com.example.infrastructure.commands.DeckCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandService {

    private final CardCommandRepository cardCommandRepository;
    private final DeckCommandRepository deckCommandRepository;


    public Card createCard(Long deckId, Card card) {
        Deck deck = deckCommandRepository.findById(deckId)
                .orElseThrow(() -> new ResourceNotFoundException("Deck not found"));

        Card newCard = new Card();
        newCard.setFrontContent(card.getFrontContent());
        newCard.setBackContent(card.getBackContent());
        newCard.setDeck(deck);
        return cardCommandRepository.save(card);
    }

    public Card updateCard(Long cardId, Card card) {
        Card result = cardCommandRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        card.setFrontContent(card.getFrontContent());
        card.setBackContent(card.getBackContent());
        return cardCommandRepository.save(card);
    }

    public void deleteCard(Long cardId) {
        cardCommandRepository.deleteById(cardId);
    }
}
