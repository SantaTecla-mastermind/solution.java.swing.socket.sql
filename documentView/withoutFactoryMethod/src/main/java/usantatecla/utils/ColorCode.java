package usantatecla.utils;

public enum ColorCode {
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    ORANGE("\u001B[37m"),
    PURPLE("\u001B[35m"),
    RESET_COLOR("\u001B[0m");

    private String color;

    ColorCode(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static String getColorByIndex(int index){
        return ColorCode.values()[index].getColor();
    }
}
