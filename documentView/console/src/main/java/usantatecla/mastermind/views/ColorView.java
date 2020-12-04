package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

class ColorView {

    private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};
    private Color color;

    ColorView(Color color) {
        this.color = color;
    }

    static String allInitials() {
        String result = "";
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            result += ColorCode.values()[i].getColor() + ColorView.INITIALS[i] + ColorCode.RESET_COLOR.getColor();
        }
        return result;
    }

    static Color getInstance(char character) {
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            if (ColorView.INITIALS[i] == character) {
                return Color.values()[i];
            }
        }
        return Color.NULL;
    }

    void write() {
        if (!color.isNull()) {
            Console.getInstance()
                    .write(ColorCode.getColorByIndex(this.color.ordinal())
                            + ColorView.INITIALS[this.color.ordinal()]
                            + ColorCode.RESET_COLOR.getColor());
        }
    }

}
