package usantatecla.mastermind.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {

    RED,
    GREEN,
    YELLOW,
    BLUE,
    MAGENTA,
    CYAN,
    NULL;

    public static List<Color> get(String initials) {
        List<Color> colors = new ArrayList<>();
        for (char initial : initials.toCharArray()) {
            colors.add(Color.get(initial));
        }
        return colors;
    }

    public static Color get(char character) {
        for (Color color : Color.getAll()) {
            if (color.getInitial() == character) {
                return color;
            }
        }
        return Color.NULL;
    }

    public static List<Color> getAll() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.values()));
        colors.remove(Color.NULL);
        return colors;
    }

    public static String getAllInitials() {
        String result = "";
        for (Color color : Color.getAll()) {
            result += color.getInitial();
        }
        return result;
    }

    public char getInitial() {
        return this.name().toLowerCase().charAt(0);
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

}
