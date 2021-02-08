package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.BoardView;
import usantatecla.mastermind.views.ViewFactory;

public abstract class Controller {

    protected Board board;
    protected ViewFactory viewFactory;

    Controller(Board board, ViewFactory viewFactory) {
        this.board = board;
        this.viewFactory = viewFactory;
    }

    void writeBoard(){
        BoardView boardView = this.viewFactory.createBoardView();
        int attempts = this.board.getAttempts();
        boardView.setAttempts(attempts);
        for (int i = 0; i < attempts; i++) {
            boardView.setProposedCombinationColors(this.board.getProposedCombinationColors(i));
            boardView.setBlacks(this.board.getBlacks(i));
            boardView.setWhites(this.board.getWhites(i));
        }
        boardView.write();
    }

}
