package usantatecla.mastermind.views;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

class ProposedCombinationView {

    ProposedCombination read() {//TODO ColorView??
        Error error;
        ProposedCombination proposedCombination = new ProposedCombination();
        do {
            String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.toString()).toLowerCase();
            error = proposedCombination.add(Color.get(characters));
            new ErrorView().writeln(error);
        } while (!error.isNull());
        return proposedCombination;
    }

    void write(ProposedCombination proposedCombination) {
        for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(proposedCombination.getColors())) {
            colorCode.write();
        }
    }

}
