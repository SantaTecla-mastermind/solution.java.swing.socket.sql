package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    @Override
    protected void start(StartController startController) {
    }

    @Override
    protected void play(PlayController playController) {
    }

    @Override
    protected boolean resume(ResumeController resumeController) {
        return true;
    }

}
