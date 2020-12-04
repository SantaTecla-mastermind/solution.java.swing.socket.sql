package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

public class View {

	private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

	public View(Game game) {
		this.startView = new StartView();
		this.proposalView = new ProposalView(game);
		this.resumeView = new ResumeView(game);
	}

	public void interact() {
		boolean newGame;
		do {
			this.startView.interact();
			boolean finished;
			do {
				finished = this.proposalView.interact();
			} while (!finished);
			newGame = this.resumeView.interact();
		} while (newGame);
	}
}
