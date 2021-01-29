package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public abstract class WithBoardView {

    protected Board board;

    protected WithBoardView(Board board) {
        this.board = board;
    }

}
