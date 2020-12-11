package usantatecla.mastermind;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind {

    private final ConsoleView consoleView;

    private ConsoleMastermind() {
        this.consoleView = new ConsoleView(new Game());
    }

    private void play() {
        this.consoleView.interact();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}
