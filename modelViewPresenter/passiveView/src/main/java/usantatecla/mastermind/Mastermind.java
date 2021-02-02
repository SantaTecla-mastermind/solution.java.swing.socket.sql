package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;

abstract class Mastermind {

	private Board board;
	private StartController startController;
	private PlayController playController;
	private ResumeController resumeController;

	protected Mastermind() {
		this.board = new Board();
		this.startController = new StartController(this.board);
		this.playController = new PlayController(this.board);
		this.resumeController = new ResumeController(this.board);
	}

	protected void play() {
		do{
			this.startController.control();
			this.playController.control();
		} while(this.resumeController.control());
	}

}
