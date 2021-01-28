package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.*;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Board board) {
        super(board);
    }

    public Error add(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination();
        Error error = proposedCombination.add(colors);
        if (error.isNull()) {
            this.board.add(proposedCombination);
        }
        return error;
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

}
