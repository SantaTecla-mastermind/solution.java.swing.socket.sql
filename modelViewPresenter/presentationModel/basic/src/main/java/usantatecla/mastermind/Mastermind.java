package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

	private Board board;
	private View view;
	protected StartController startController;
	protected PlayController playController;
	protected ResumeController resumeController;

	protected Mastermind() {
		this.board = new Board();
		this.startController = new StartController(this.board);
		this.playController = new PlayController(this.board);
		this.resumeController = new ResumeController(this.board);
		this.view = this.createView();
	}

	protected abstract View createView();

	protected void play() {
		do {
			this.view.start();
			this.view.play();
		} while (this.view.resume());
	}

}
