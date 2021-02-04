package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;

public abstract class View {

	public View() {

	}

	//TODO necesario instance of??
	public void interact(Logic logic) {
		do {
			this.start((StartController) logic.getController());
			this.play((PlayController) logic.getController());
		} while (this.resume((ResumeController) logic.getController()));
	}

	protected abstract void start(StartController startController);

	protected abstract void play(PlayController playController);

	protected abstract boolean resume(ResumeController resumeController);
	
}
