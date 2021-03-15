package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;

public abstract class View  extends WithLogicView {

	public View(Logic logic) {
		super(logic);
	}

	public abstract void start();

	public abstract void play();

	public abstract boolean resume();
	
}
