package com.example.application.commands;


import com.example.domain.entities.Deck;
import com.example.infrastructure.commands.DeckCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeckCommandService {
    private final DeckCommandRepository deckCommandRepository;

    public Deck createDeck(Deck deck) {
        return deckCommandRepository.save(deck);
    }

    public Deck updateDeck(Long deckId, Deck deck) {
        Deck result = deckCommandRepository.findById(deckId)
                .orElseThrow(() -> new ResourceNotFoundException("Deck not found"));

        return deckCommandRepository.save(deck);
    }

    public void deleteDeck(Long deckId) {
        Deck result = deckCommandRepository.findById(deckId).orElseThrow(() -> new ResourceNotFoundException("Deck not found"));
        deckCommandRepository.delete(result);
    }
}
