package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    public GraphicsView(StartController startController, PlayController playController,
                        ResumeController resumeController) {
        super(startController, playController, resumeController);
    }

    @Override
    protected void start() {
    }

    @Override
    protected void play() {
    }

    @Override
    protected boolean resume() {
        return true;
    }

}
