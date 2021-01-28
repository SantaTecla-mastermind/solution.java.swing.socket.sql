package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;

public abstract class View {

	protected StartController startController;
	protected PlayController playController;
	protected ResumeController resumeController;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
		this.startController = startController;
		this.playController = playController;
		this.resumeController = resumeController;
	}

	public void interact() {
		do {
			this.start();
			this.play();
		} while (this.resume());
	}

	protected abstract void start();

	protected abstract void play();

	protected abstract boolean resume();
	
}
