package com.example.api.card;

import com.example.application.commands.CardCommandService;
import com.example.application.queries.CardQueryService;
import com.example.domain.entities.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;


    @PostMapping("/decks/{deckId}/cards")
    public ResponseEntity<Card> createCard(
            @PathVariable Long deckId,
            @RequestBody Card card) {
        Card result = cardCommandService.createCard(deckId, card);
        return ResponseEntity.created(URI.create("/decks/" + deckId + "/cards/" + result.getId())).build();
    }

    @PutMapping("/cards/{cardId}")
    public ResponseEntity<Card> updateCard(
            @PathVariable Long cardId,
            @RequestBody Card card){

        Card updatedCard = cardCommandService.updateCard(cardId, card);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cards/{cardId}")
    public ResponseEntity<Void> deleteCard(
            @PathVariable Long cardId) {
        cardCommandService.deleteCard(cardId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/decks/{deckId}/cards")
    public ResponseEntity<List<Card>> getCardsByDeck(
            @PathVariable Long deckId) {

        List<Card> cards = cardQueryService.getCardsByDeckId(deckId);

        return ResponseEntity.ok().build();
    }
}
