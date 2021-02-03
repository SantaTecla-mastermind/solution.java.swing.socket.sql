package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.BoardView;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.ProposedCombinationView;

public abstract class Controller {

    protected Board board;
    protected ViewFactory viewFactory;

    Controller(Board board, ViewFactory viewFactory) {
        this.board = board;
        this.viewFactory = viewFactory;
    }

    public void writeBoard(){
        BoardView boardView = this.viewFactory.createBoardView();
        int attempts = this.board.getAttempts();
        boardView.setAttempts(attempts);
        for (int i = 0; i < attempts; i++) {
            boardView.setProposedCombinationColors(this.board.getProposedCombinationColors(i));
            boardView.setBlacks(this.board.getBlacks(i));
            boardView.setWhites(this.board.getWhites(i));
            boardView.writeResult(this.getBlacks(i), this.getWhites(i));
        }
    }


    public int getBlacks(int position) {
        return this.board.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.board.getWhites(position);
    }

}
