package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;

public abstract class Controller {

    protected Board board;

    Controller(Board board) {
        this.board = board;
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
