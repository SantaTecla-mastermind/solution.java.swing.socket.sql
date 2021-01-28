package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;

public abstract class Controller {

    protected Board board;

    Controller(Board board) {
        this.board = board;
    }

    public int getAttempts() {
        return this.board.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.board.getProposedCombination(position);
    }

    public int getBlacks(int position) {
        return this.board.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.board.getWhites(position);
    }

}
