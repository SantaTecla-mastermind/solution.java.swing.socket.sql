package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    public GraphicsView(Logic logic) {
        super(logic);
    }

    @Override
    protected void start() {

    }

    @Override
    protected boolean propose() {
        return false;
    }

    @Override
    protected boolean isNewGame() {
        return false;
    }

}
