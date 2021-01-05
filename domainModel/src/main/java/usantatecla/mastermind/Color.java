package usantatecla.mastermind;

import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    CYAN('o'),
    MAGENTA('p'),
    NULL_COLOR;

    private char initial;

    Color() {
    }

    Color(char initial) {
        this.initial = initial;
    }

    static String getInitials() {
        String result = "";
        for (int i = 0; i < Color.length(); i++) {
            result += ColorCode.values()[i].getColor() + Color.get(i).initial + ColorCode.RESET_COLOR.getColor();
        }
        return result;
    }

    static Color getInstance(char character) {
        for (int i = 0; i < Color.length(); i++) {
            if (Color.get(i).initial == character) {
                return Color.get(i);
            }
        }
        return Color.NULL_COLOR;
    }

    static int length() {
        return Color.values().length - 1;
    }

    static Color get(int index) {
        return Color.values()[index];
    }

    void write() {
        assert this != Color.NULL_COLOR;
        Console.getInstance()
                .write(ColorCode.getColorByIndex(getInstance(initial).ordinal())
                        + initial
                        + ColorCode.RESET_COLOR.getColor());
    }

    boolean isNull() {
        return this == Color.NULL_COLOR;
    }

}
