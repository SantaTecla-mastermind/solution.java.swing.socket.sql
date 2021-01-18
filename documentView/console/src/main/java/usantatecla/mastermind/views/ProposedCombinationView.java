package usantatecla.mastermind.views;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

class ProposedCombinationView {

    ProposedCombination read() {
        Error error;
        ProposedCombination proposedCombination = new ProposedCombination();
        do {
            String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.toString()).toLowerCase();
            error = proposedCombination.getColorCodesError(characters);
            new ErrorView().writeln(error);
            if (!error.isNull()) {
                proposedCombination.reset();
            }
        } while (!error.isNull());
        return proposedCombination;
    }

    void write(ProposedCombination proposedCombination) {
        for (ColorCode colorCode : proposedCombination.getColorCodes()) {
            colorCode.write();
        }
    }

}
