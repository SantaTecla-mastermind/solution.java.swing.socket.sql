package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public abstract class View extends WithBoardView {

    public View(Board board) {
        super(board);
    }

    protected abstract void start();

    protected abstract void play();

    protected abstract boolean resume();

}
