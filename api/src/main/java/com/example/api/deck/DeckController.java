package com.example.api.deck;

import com.example.application.commands.DeckCommandService;
import com.example.domain.entities.Deck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckCommandService deckCommandService;


    @PostMapping
    ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck result = deckCommandService.createDeck(deck);
        return ResponseEntity.created(URI.create("/decks/" + result.getId())).body(result);
    }
}
