package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.console.BoardView;
import usantatecla.mastermind.views.console.ProposedCombinationView;
import usantatecla.utils.views.Console;

public abstract class Controller {

    protected Board board;

    Controller(Board board) {
        this.board = board;
    }

    public void writeBoard(){
        BoardView boardView = new BoardView();
        boardView.writeln();
        int attempts = this.getAttempts();
        boardView.writeAttempts(attempts);
        boardView.writeSecretCombination();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(this.getProposedCombinationColors(i));
            boardView.writeResult(this.getBlacks(i), this.getWhites(i));
        }
    }

    public int getAttempts() {
        return this.board.getAttempts();
    }

    public List<Color> getProposedCombinationColors(int position) {
        return this.board.getProposedCombinationColors(position);
    }

    public int getBlacks(int position) {
        return this.board.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.board.getWhites(position);
    }

}
