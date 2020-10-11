package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private ProposalView proposalView;

	private ResumeView resumeView;

	public ConsoleView(StartController startController, ProposalController proposalController, ResumeController resumeController) {
		super(startController, proposalController, resumeController);
		this.startView = new StartView(this.startController);
		this.proposalView = new ProposalView(this.proposalController);
		this.resumeView = new ResumeView(this.resumeController);
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected boolean propose() {
		return this.proposalView.interact();
	}

	@Override
	protected boolean isNewGame() {
		return this.resumeView.interact();
	}

}
