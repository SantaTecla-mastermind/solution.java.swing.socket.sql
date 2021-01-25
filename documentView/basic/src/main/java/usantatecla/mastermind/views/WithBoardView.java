package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

abstract class WithBoardView {

    protected Board board;

    WithBoardView(Board board) {
        this.board = board;
    }
}
