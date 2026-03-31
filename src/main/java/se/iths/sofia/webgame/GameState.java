package se.iths.sofia.webgame;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import se.iths.sofia.webgame.model.Place;

@Component
@SessionScope
public class GameState {
    private Place currentPlace = Place.CENTRAL;

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }
}
