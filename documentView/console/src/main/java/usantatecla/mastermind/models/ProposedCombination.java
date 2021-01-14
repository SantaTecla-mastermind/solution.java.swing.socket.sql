package usantatecla.mastermind.models;

import usantatecla.utils.ColorCode;

public class ProposedCombination extends Combination {

    boolean contains(ColorCode colorCode, int position) {
        assert position < this.colorCodes.size();

        return this.colorCodes.get(position) == colorCode;
    }

    boolean contains(ColorCode colorCode) {
        return this.colorCodes.contains(colorCode);
    }

}
