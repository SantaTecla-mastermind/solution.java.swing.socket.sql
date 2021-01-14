package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

public class View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(Game game) {
		this.startView = new StartView();
		this.playView = new PlayView(game);
		this.resumeView = new ResumeView(game);
	}

	public void interact() {
		do {
			this.startView.interact();
			this.playView.interact();
		} while (this.resumeView.interact());
	}
}
