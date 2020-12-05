package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.utils.Console;

class ProposedCombinationView {

    private ProposedCombination proposedCombination;

    ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    void write() {
        for (Color color : this.proposedCombination.getColors()) {
            new ColorView(color).write();
        }
    }

    void read() {
        Error error;
        do {
            error = Error.NULL;
            Console.getInstance().write(Message.PROPOSED_COMBINATION.getMessage());
            String characters = Console.getInstance().readString();

            if (characters.length() > Combination.getWidth() || characters.length() < Combination.getWidth()) {
                error = Error.WRONG_LENGTH;
            } else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = ColorView.getInstance(characters.charAt(i));
                    if (color.isNull()) {
                        error = Error.WRONG_CHARACTERS;
                    } else {
                        if (this.proposedCombination.getColors().contains(color)) {
                            error = Error.DUPLICATED;
                        } else {
                            this.proposedCombination.getColors().add(color);
                        }
                    }
                }
            }
            if (!error.isNull()) {
                new ErrorView(error).writeln();
                this.proposedCombination.getColors().clear();
            }
        } while (!error.isNull());
    }

}
