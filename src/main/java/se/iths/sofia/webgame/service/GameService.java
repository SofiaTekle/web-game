package se.iths.sofia.webgame.service;

import org.springframework.stereotype.Service;
import se.iths.sofia.TextFormatter;
import se.iths.sofia.webgame.GameState;
import se.iths.sofia.webgame.model.Place;

@Service
public class GameService {
    private final GameState gameState;
    private final TextFormatter textFormatter;

    public GameService(GameState gameState, TextFormatter textFormatter) {
        this.gameState = gameState;
        this.textFormatter = textFormatter;
    }


    public void handleCommand(String command) {
        String cmd = textFormatter.stripWhitespace(textFormatter.toLowerCase(command));

        switch (cmd) {
            case "gå norrut" -> gameState.setCurrentPlace(Place.NORTH);
            case "gå söderut" -> gameState.setCurrentPlace(Place.SOUTH);
            case "gå till centrum" -> gameState.setCurrentPlace(Place.CENTRAL);
        }

    }

    public GameState getGameState() {
        return gameState;
    }


}
