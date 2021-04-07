package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
