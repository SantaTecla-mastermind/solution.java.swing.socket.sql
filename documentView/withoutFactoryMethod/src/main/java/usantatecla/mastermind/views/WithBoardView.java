package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public abstract class WithBoardView {

    protected Board board;

    public WithBoardView(Board board) { // TODO public a protected
        this.board = board;
    }
    
}
