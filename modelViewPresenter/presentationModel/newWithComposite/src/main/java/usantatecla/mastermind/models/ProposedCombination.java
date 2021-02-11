package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.ArrayList;
import java.util.List;

class ProposedCombination extends Combination {

    ProposedCombination(List<Color> colors) {
        this.colors = colors;
    }

    List<Color> getColors() {
        return colors;
    }

    Error getError() {
        List<Color> correctColors = new ArrayList<>();
        if (this.colors.size() != Result.WIDTH) {
            return Error.WRONG_LENGTH;
        }
        for (int i = 0; i < this.colors.size(); i++) {
            Color color = this.colors.get(i);
            if (color.isNull()) {
                return Error.WRONG_CHARACTERS;
            }
            for (int j = 0; j < i; j++) {
                if (correctColors.get(j) == color) {
                    return Error.DUPLICATED;
                }
            }
            correctColors.add(color);
        }
        return Error.NULL;
    }

    boolean contains(Color color, int position) {
        assert position < this.colors.size();

        return this.colors.get(position) == color;
    }

    boolean contains(Color color) {
        return this.colors.contains(color);
    }

}
