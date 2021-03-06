package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

import java.util.ArrayList;
import java.util.List;

class ProposedCombinationView {

    List<Color> read(Board board) {
        Error error;
        List<Color> colors = new ArrayList<>();
        do {
            String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.toString()).toLowerCase();
            colors = Color.get(characters);
            error = board.getError(colors);
            new ErrorView().writeln(error);
        } while (!error.isNull());
        return colors;
    }

    void write(List<Color> colors) {
        for (ColorCode colorCode : this.getColorCodes(colors)) {
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
