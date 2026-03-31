package se.iths.sofia.webgame.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.sofia.webgame.model.MoveForm;
import se.iths.sofia.webgame.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // skapar ett tomt formulär + hämtar current state
    @GetMapping
    public String showGame(Model model) {
        model.addAttribute("moveForm", new MoveForm());
        model.addAttribute("gameState", gameService.getGameState());
        return "game";
    }

    @PostMapping
    public String handleForm(@Valid MoveForm moveForm,
                             BindingResult bindingResult,
                             Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("gameState", gameService.getGameState());
            return "game";
        }
        String command = moveForm.getCommand();
        gameService.handleCommand(command);
        model.addAttribute("gameState", gameService.getGameState());
        model.addAttribute("moveForm", new MoveForm());
        return "game";

    }


}
