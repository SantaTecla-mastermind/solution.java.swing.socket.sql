package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Color;

class ColorView extends usantatecla.mastermind.views.ColorView {

    ColorView() { }

    ColorView(Color color) {
        super(color);
    }

    @Override
    protected String resultInitials(int i) {
        return String.valueOf(ColorView.INITIALS[i]);
    }
}
