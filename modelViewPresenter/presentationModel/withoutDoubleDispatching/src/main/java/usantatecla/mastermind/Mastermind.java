package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic();
		this.view = this.createView();
	}

	protected abstract View createView();

	protected void play() {
		this.view.interact(this.logic);
	}

}
