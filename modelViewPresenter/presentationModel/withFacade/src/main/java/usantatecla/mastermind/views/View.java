package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;

public abstract class View  extends WithLogicView {

	public View(Logic logic) {
		super(logic);
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
