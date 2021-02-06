package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationView implements usantatecla.mastermind.views.ProposedCombinationView {

    public String read() {
        return Console.getInstance().readString(Message.PROPOSED_COMBINATION.toString()).toLowerCase();
    }

    public void write(List<Color> colors) {
        for (ColorCode colorCode : this.getColorCodes(colors)) {
            colorCode.write();
        }
    }

    // TODO Revisar si en esta versión esto se queda aquí (acoplamiento en Conversor, test)
    public List<ColorCode> getColorCodes(List<Color> colors) {
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
