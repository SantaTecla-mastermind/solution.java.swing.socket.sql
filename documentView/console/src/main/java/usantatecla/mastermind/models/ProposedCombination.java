package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.ColorCode;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombination extends Combination {

    public List<Color> getColors() {
        return colors;
    }

    public Error add(List<Color> colors) {//TODO Assert y reset ?
        assert this.colors.isEmpty();

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
        this.colors = correctColors;
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
