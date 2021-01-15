package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public class View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(Board board) {
		this.startView = new StartView(board);
		this.playView = new PlayView(board);
		this.resumeView = new ResumeView(board);
	}

	public void interact() {
		do {
			this.startView.interact();
			this.playView.interact();
		} while (this.resumeView.interact());
	}
}
