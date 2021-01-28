package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.ColorCode;

import java.util.List;

class Conversor {

    String toColorCodeString(String initials) {
        List<ColorCode> colorCodes = new ProposedCombinationView().getColorCodes(Color.get(initials));
        String string = "";
        for (ColorCode colorCode : colorCodes) {
            string += colorCode.toString();
        }
        return string;
    }

    String arrayToString(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object;
        }
        return string;
    }

}
