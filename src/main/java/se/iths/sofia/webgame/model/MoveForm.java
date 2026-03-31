package se.iths.sofia.webgame.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MoveForm {

    @NotBlank(message = "Du måste skriva ett kommando")
    private String command;

    @Min(value = 1, message = "Måste vara över ett eller lika med")
    @Max(value = 10, message = "Måste vara 10 eller under")
    private int level;

    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Ogiltig e-mail"
    )
    private String email;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
