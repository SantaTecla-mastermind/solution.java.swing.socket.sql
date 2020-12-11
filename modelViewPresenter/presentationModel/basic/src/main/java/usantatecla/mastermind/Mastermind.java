package usantatecla.mastermind;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

    private final View view;

    protected Mastermind() {
        Game game = new Game();
        this.view = this.createView(new StartController(game), new ProposalController(game), new ResumeController(game));
    }

    protected abstract View createView(StartController startController, ProposalController proposalController, ResumeController resumeController);

    protected void play() {
        this.view.interact();
    }

}
