package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;

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
