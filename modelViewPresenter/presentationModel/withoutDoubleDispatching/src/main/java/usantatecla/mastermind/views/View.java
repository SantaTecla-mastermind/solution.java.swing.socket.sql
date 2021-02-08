package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;

public abstract class View {

	public View() {

	}

	public void interact(Logic logic) {
		do {
			if (logic.getController() instanceof StartController) {
				this.start((StartController) logic.getController());
			} else {
				if (logic.getController() instanceof PlayController) {
					this.play((PlayController) logic.getController());
				} else {
					this.resume((ResumeController) logic.getController());
				}
			}
		} while (logic.getController() != null);
	}

	protected abstract void start(StartController startController);

	protected abstract void play(PlayController playController);

	protected abstract boolean resume(ResumeController resumeController);
	
}
