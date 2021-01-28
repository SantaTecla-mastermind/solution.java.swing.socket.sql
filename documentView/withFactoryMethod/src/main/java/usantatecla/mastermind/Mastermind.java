package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

    private final View view;
    private final Board board;

    protected Mastermind() {
        this.board = new Board();
        this.view = this.createView(this.board);
    }

    protected abstract View createView(Board board);

    protected void play() {
        this.view.interact();
    }

}
