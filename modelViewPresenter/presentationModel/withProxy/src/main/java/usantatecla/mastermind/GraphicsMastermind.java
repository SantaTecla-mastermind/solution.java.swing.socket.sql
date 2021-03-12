package usantatecla.mastermind;

import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView();
    }

    @Override
    protected Boolean isStandalone() {
        return true;
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
