package usantatecla.mastermind.views.graphics;

class ColorView extends usantatecla.mastermind.views.ColorView {

    ColorView() {
    }

    @Override
    protected String resultInitials(int i) {
        return String.valueOf(ColorView.INITIALS[i]);
    }
}
