package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationView {

    ProposedCombination read() {
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
        for (ColorCode colorCode : this.getColorCodes(proposedCombination.getColors())) {
            colorCode.write();
        }
    }

    List<ColorCode> getColorCodes(List<Color> colors) {
        List<ColorCode> colorCodes = new ArrayList<>();
        for (Color color : colors) {
            for (ColorCode colorCode : ColorCode.values()) {
                if (color.name().equals(colorCode.name())) {
                    colorCodes.add(colorCode);
                }
            }
        }
        return colorCodes;
    }

}
