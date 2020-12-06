package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

    public GraphicsView(StartController startController, ProposalController proposalController,
                        ResumeController resumeController) {
        super(startController, proposalController, resumeController);
        //TODO Graphics
    }

    @Override
    protected void start() {
    }

    @Override
    protected boolean propose() {
        return true;
    }

    @Override
    protected boolean isNewGame() {
        return true;
    }

}
