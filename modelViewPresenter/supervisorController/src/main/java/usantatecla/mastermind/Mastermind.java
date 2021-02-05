package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;

abstract class Mastermind {

	private Board board;
	private ViewFactory viewFactory;
	private StartController startController;
	private PlayController playController;
	private ResumeController resumeController;

	protected Mastermind() {
		this.board = new Board();
		this.viewFactory = this.createViewFactory();
		this.startController = new StartController(this.board, this.viewFactory);
		this.playController = new PlayController(this.board, this.viewFactory);
		this.resumeController = new ResumeController(this.board, this.viewFactory);
	}

	protected abstract ViewFactory createViewFactory();

	protected void play() {
		do{
			this.startController.control();
			this.playController.control();
		} while(this.resumeController.control());
	}

}
