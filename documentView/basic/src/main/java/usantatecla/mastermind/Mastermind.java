package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

class Mastermind {

    private Board board;
    private View view;

    Mastermind() {
        this.board = new Board();
        this.view = new View(this.board);
    }

    private void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
