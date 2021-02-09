package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView(Logic logic) {
        return new GraphicsView(logic);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
