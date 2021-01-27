package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private final View view;
	private final Board board;
	private final StartController startController;
	private final PlayController playController;
	private final ResumeController resumeController;

	protected Mastermind() {
		this.board = new Board();
		this.startController = new StartController(this.board);
		this.playController = new PlayController(this.board);
		this.resumeController = new ResumeController(this.board);
		this.view = this.createView(startController, playController, resumeController);
	}

	protected abstract View createView(StartController startController, PlayController playController, ResumeController resumeController);

	protected void play() {
		this.view.interact();
	}

}
