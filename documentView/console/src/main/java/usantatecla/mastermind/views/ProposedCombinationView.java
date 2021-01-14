package usantatecla.mastermind.views;

import usantatecla.mastermind.models.ColorFactory;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.utils.ColorCode;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

import java.util.ArrayList;

class ProposedCombinationView {

    private ProposedCombination proposedCombination;

    ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    ProposedCombination read() {
        Error error;
        do {
            Message.PROPOSED_COMBINATION.write();
            error = this.getColorCodesError();
            new ErrorView(error).writeln();
            if (!error.isNull()) {
                this.proposedCombination.setColorCodes(new ArrayList<>()); // TODO ¿setColorCodes o reset?
            }
        } while (!error.isNull());
        return this.proposedCombination;
    }

    private Error getColorCodesError() {
        String characters = Console.getInstance().readString().toLowerCase();
        if (characters.length() != Result.WIDTH) {
            return Error.WRONG_LENGTH;
        }
        for (int i = 0; i < characters.length(); i++) {
            ColorCode colorCode = ColorFactory.getInstance().getColorCode(characters.charAt(i));
            if (colorCode.isNull()) {
                return Error.WRONG_CHARACTERS;
            }
            for (int j = 0; j < i; j++) {
                if (this.proposedCombination.getColorCodes().get(j) == colorCode) {
                    return Error.DUPLICATED;
                }
            }
            this.proposedCombination.add(colorCode); //TODO Bajo demanda se ha añadido metodo add en Combination
        }
        return Error.NULL;
    }

    void write() {
        for (ColorCode colorCode : this.proposedCombination.getColorCodes()) {
            colorCode.write();
        }
    }

}
