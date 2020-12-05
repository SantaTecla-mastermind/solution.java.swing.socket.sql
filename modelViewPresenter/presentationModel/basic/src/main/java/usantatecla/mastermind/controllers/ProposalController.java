package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.*;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class ProposalController extends Controller {

    public ProposalController(Game game) {
        super(game);
    }

    public Error addProposedCombination(List<Color> colors) {
        Error error = Error.NULL;
        if (colors.size() != Combination.getWidth()) {
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
            this.game.addProposedCombination(proposedCombination);
        }
        return error;
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.game.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.game.getResult(position);
    }

}
