package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.ColorCode;

import java.util.List;

// TODO Revisar con Luis
class ViewTestUtils {
    String toColorCodeString(String initials) {
        List<ColorCode> colorCodes = new ProposedCombinationView().getColorCodes(Color.get(initials));
        String string = "";
        for (ColorCode colorCode : colorCodes) {
            string += colorCode.toString();
        }
        return string;
    }

    String arrayToString(Object[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            stringBuilder.append(stringArray[i]);
        }
        return stringBuilder.toString();
    }
}
