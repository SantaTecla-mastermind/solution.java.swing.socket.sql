package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind { // TODO Quitar public

    private Board board;
    private final ConsoleView consoleView; // TODO Quitar final

    private ConsoleMastermind() {
        this.board = new Board();
        this.consoleView = new ConsoleView(this.board);
    }

    private void play() {
        this.consoleView.interact();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }

}
