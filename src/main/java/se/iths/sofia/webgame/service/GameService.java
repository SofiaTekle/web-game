package se.iths.sofia.webgame.service;

import org.springframework.stereotype.Service;
import se.iths.sofia.webgame.GameState;
import se.iths.sofia.webgame.model.Place;

@Service
public class GameService {
    private final GameState gameState;

    public GameService(GameState gameState) {
        this.gameState = gameState;
    }

    public void handleCommand(String command) {
        String cmd = command.trim().toLowerCase();

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
