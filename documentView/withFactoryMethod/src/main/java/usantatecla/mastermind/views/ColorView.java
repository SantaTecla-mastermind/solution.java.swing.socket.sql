package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;

public abstract class ColorView {

    public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};
    protected Color color;

    protected ColorView() {
    }

    protected ColorView(Color color) {
        this.color = color;
    }

    public String allInitials() {
        String result = "";
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            result += resultInitials(i);
        }
        return result;
    }

    protected abstract String resultInitials(int i);

    public static Color getInstance(char character) {
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            if (ColorView.INITIALS[i] == character) {
                return Color.values()[i];
            }
        }
        return Color.NULL;
    }
}
