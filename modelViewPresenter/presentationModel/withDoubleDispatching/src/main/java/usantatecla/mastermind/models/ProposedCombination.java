package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.List;

public class ProposedCombination extends Combination {

    boolean contains(Color color, int position) {
        assert position < this.colors.size();

        return this.colors.get(position) == color;
    }

    boolean contains(Color color) {
        return this.colors.contains(color);
    }

    public List<Color> getColors() {
        return this.colors;
    }

}
