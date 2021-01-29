package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

	private View view;

	protected Mastermind() {
		this.view = this.createView(new Logic(new Board()));
	}

	protected abstract View createView(Logic logic);

	protected void play() {
		this.view.interact();
	}

}
