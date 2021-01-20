package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.ColorCode;

import java.util.ArrayList;
import java.util.List;

class ColorFactory {//TODO Nombre y existencia ???

    private static ColorFactory instance = new ColorFactory();

    public static ColorFactory getInstance() {
        return ColorFactory.instance;
    }

    List<ColorCode> getColorCodes(List<Color> colors) {
        List<ColorCode> colorCodes = new ArrayList<>();
        for (Color color : colors) {
            ColorCode colorCode = this.getColorCode(color);
            if (!colorCode.isNull()) {
                colorCodes.add(colorCode);
            }
        }
        return colorCodes;
    }

    private ColorCode getColorCode(Color color) {
        for (ColorCode colorCode : ColorCode.values()) {
            if (color.name().equals(colorCode.name())) {
                return colorCode;
            }
        }
        return ColorCode.NULL;
    }

}
