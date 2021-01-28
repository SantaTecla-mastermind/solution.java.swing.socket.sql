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
        Error error = Error.NULL;
        if (colors.size() != Result.WIDTH) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i).isNull()) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i + 1; j < colors.size(); j++) {
                        if (colors.get(i).equals(colors.get(j))) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error.isNull()) {
            ProposedCombination proposedCombination = new ProposedCombination();
            proposedCombination.getColors().addAll(colors);
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
