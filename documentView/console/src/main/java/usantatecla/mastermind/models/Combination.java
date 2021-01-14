package usantatecla.mastermind.models;

import usantatecla.utils.ColorCode;

import java.util.ArrayList;
import java.util.List;

abstract class Combination {

    protected List<ColorCode> colorCodes;

    protected Combination() {
        this.colorCodes = new ArrayList<>();
    }

    public List<ColorCode> getColorCodes() {
        return colorCodes;
    }

    public void setColorCodes(List<ColorCode> colorCodes) {
        this.colorCodes = colorCodes;
    }

    public void add(ColorCode colorCode) {
        this.colorCodes.add(colorCode);
    }

}
