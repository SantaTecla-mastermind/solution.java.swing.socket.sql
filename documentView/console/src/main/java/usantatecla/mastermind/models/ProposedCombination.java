package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.ColorCode;

import java.util.List;

public class ProposedCombination extends Combination {

    public List<ColorCode> getColorCodes() {
        return colorCodes;
    }

    public void add(ColorCode colorCode) {
        this.colorCodes.add(colorCode);
    }

    public void reset() {
        this.colorCodes.clear();
    }

    public Error getColorCodesError(String characters) { //TODO Método con dos responsabilidades, el nombre no indica que se añade el color
        if (characters.length() != Result.WIDTH) {
            return Error.WRONG_LENGTH;
        }
        for (int i = 0; i < characters.length(); i++) {
            ColorCode colorCode = ColorFactory.getInstance().getColorCode(characters.charAt(i));
            if (colorCode.isNull()) {
                return Error.WRONG_CHARACTERS;
            }
            for (int j = 0; j < i; j++) {
                if (this.getColorCodes().get(j) == colorCode) {
                    return Error.DUPLICATED;
                }
            }
            this.add(colorCode);
        }
        return Error.NULL;
    }

    boolean contains(ColorCode colorCode, int position) {
        assert position < this.colorCodes.size();

        return this.colorCodes.get(position) == colorCode;
    }

    boolean contains(ColorCode colorCode) {
        return this.colorCodes.contains(colorCode);
    }

}
