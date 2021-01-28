package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

class Mastermind {

    private final Board board;
    private final View view;

    Mastermind() {
        this.board = new Board();
        this.view = new View(this.board);
    }

    private void play() {
        this.view.interact();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
