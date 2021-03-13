package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private View view;
	protected Logic logic;

	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = this.createView();
	}

	protected abstract View createView();

	protected abstract Logic createLogic();

	protected void play() {
		this.view.interact(this.logic);
	}

}
