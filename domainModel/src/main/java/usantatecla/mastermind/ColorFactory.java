package usantatecla.mastermind;

import usantatecla.utils.ColorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorFactory {

    private static final ColorCode[] COLORS = {
            ColorCode.RED,
            ColorCode.BLUE,
            ColorCode.YELLOW,
            ColorCode.GREEN,
            ColorCode.CYAN,
            ColorCode.MAGENTA
    };

    private static ColorFactory instance = new ColorFactory();

    public static ColorFactory getInstance() {
        return instance;
    }

    String getInitials() {
        String result = "";
        for (ColorCode color : COLORS) {
            result += color.getInitial();
        }
        return result;
    }

    ColorCode getColorByCharacter(char character) {
        for (ColorCode color : COLORS) {
            if (color.getInitial() == character) {
                return color;
            }
        }
        return ColorCode.NULL;
    }

    List<ColorCode> getAllColors() {
        return new ArrayList<>(Arrays.asList(COLORS));
    }

}
