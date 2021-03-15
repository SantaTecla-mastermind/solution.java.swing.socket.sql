package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
