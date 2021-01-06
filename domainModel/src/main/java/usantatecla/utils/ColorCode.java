package usantatecla.utils;

public enum ColorCode {

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    RESET_COLOR("\u001B[0m"),
    NULL;

    private String color;

    ColorCode() {
    }

    ColorCode(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static String getColorByIndex(int index) {
        return ColorCode.values()[index].getColor();
    }

    public char getInitial() {
        return this.name().toLowerCase().charAt(0);
    }

    public boolean isNull() {
        return this == ColorCode.NULL;
    }

}
