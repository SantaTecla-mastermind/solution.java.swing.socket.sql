package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic(new Board());
		this.view = this.createView(this.logic);
	}

	protected abstract View createView(Logic logic);

	protected void play() {
		do {
			this.view.start();
			this.view.play();
		} while (this.view.resume());
	}

}
