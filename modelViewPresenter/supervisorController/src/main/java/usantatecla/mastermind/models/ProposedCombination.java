package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombination extends Combination {

    public ProposedCombination(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }

    public Error getError() {
        List<Color> correctColors = new ArrayList<>();
        if (colors.size() != Result.WIDTH) {
            return Error.WRONG_LENGTH;
        }
        for (int i = 0; i < colors.size(); i++) {
            Color color = colors.get(i);
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
