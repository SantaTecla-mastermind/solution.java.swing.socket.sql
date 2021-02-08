package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationView implements usantatecla.mastermind.views.ProposedCombinationView {

    public List<Color> read() {
        return Color.get(Console.getInstance().readString(Message.PROPOSED_COMBINATION.toString()).toLowerCase());
    }

    public void write(List<Color> colors) {
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
