package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

    private View view;
    private Board board;

    protected Mastermind() {
        this.board = new Board();
        this.view = this.createView(this.board);
    }

    protected abstract View createView(Board board);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

}
