package usantatecla.mastermind;

import usantatecla.mastermind.views.graphics.GraphicsViewFactory;

class GraphicsMastermind extends Mastermind{

    @Override
    protected GraphicsViewFactory createViewFactory() {
        return new GraphicsViewFactory();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }

}
