package com.example.api.deck;

import com.example.application.commands.DeckCommandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decks")
public class DeckController {

    private final DeckCommandService deckCommandService;

    public DeckController(DeckCommandService deckCommandService) {
        this.deckCommandService = deckCommandService;
    }
}
