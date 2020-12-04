package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

class ColorView extends usantatecla.mastermind.views.ColorView {

    ColorView() {
    }

    ColorView(Color color) {
        super(color);
    }

    @Override
    protected String resultInitials(int i) {
        return ColorCode.values()[i].getColor() + ColorView.INITIALS[i] + ColorCode.RESET_COLOR.getColor();
    }

    void write() {
        if (!color.isNull()) {
            Console.getInstance()
                    .write(ColorCode.getColorByIndex(this.color.ordinal())
                            + ColorView.INITIALS[this.color.ordinal()]
                            + ColorCode.RESET_COLOR.getColor());
        }
    }

}
