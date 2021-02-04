package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;

import java.util.List;

public abstract class Controller {

    protected Board board;
    protected State state;

    Controller(Board board, State state) {
        this.board = board;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
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
