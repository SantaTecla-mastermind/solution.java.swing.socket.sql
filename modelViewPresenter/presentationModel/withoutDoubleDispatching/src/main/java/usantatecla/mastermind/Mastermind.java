package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic(new Board());
		this.view = this.createView();
	}

	protected abstract View createView();

	protected void play() {
		this.view.interact(this.logic);
	}

}
