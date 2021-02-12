package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    @Override
    public void visit(StartController startController) {
    }

    @Override
    public void visit(PlayController playController) {
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
