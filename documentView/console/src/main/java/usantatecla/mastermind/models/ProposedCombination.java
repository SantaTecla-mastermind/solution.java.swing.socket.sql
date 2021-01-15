package usantatecla.mastermind.models;

import usantatecla.utils.ColorCode;

import java.util.List;

public class ProposedCombination extends Combination {

    public List<ColorCode> getColorCodes() {
        return colorCodes;
    }

    public void reset() {
        this.colorCodes.clear();
    }

    public void add(ColorCode colorCode) {
        this.colorCodes.add(colorCode);
    }

    boolean contains(ColorCode colorCode, int position) {
        assert position < this.colorCodes.size();

        return this.colorCodes.get(position) == colorCode;
    }

    boolean contains(ColorCode colorCode) {
        return this.colorCodes.contains(colorCode);
    }

}
