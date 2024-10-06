package com.example.api.deck;

import com.example.application.commands.DeckCommandService;
import com.example.application.queries.DeckQueryService;
import com.example.domain.entities.Deck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckCommandService deckCommandService;
    private final DeckQueryService deckQueryService;

    @GetMapping
    public ResponseEntity<List<Deck>> getUserDecks() {;
        List<Deck> decks = deckQueryService.getUserDecks();

        return ResponseEntity.ok().build();
    }

    @PostMapping
    ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck result = deckCommandService.createDeck(deck);
        return ResponseEntity.created(URI.create("/decks/" + result.getId())).body(result);
    }

    @PutMapping("/{deckId}")
    public ResponseEntity<Deck> updateDeck(
            @PathVariable Long deckId,
            @RequestBody Deck deck) {
        Deck updatedDeck = deckCommandService.updateDeck(deckId, deck);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<Void> deleteDeck(
            @PathVariable Long deckId) {
        deckCommandService.deleteDeck(deckId);
        return ResponseEntity.noContent().build();
    }

}
