package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind {

    private Board board;
    private ConsoleView consoleView;

    private ConsoleMastermind() {
        this.board = new Board();
        this.consoleView = new ConsoleView(this.board);
    }

    private void play() {
        do {
            this.consoleView.start();
            this.consoleView.play();
        } while (this.consoleView.resume());
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }

}
