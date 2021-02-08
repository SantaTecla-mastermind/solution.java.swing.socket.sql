package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;

import java.util.List;

public class StartController extends Controller {

    public StartController(Board board) {
        super(board);
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
