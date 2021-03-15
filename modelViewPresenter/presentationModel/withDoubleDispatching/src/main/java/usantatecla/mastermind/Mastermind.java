package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic();
		this.view = this.createView();
	}

	protected abstract View createView();

	protected void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null)
				controller.accept(this.view);
		} while (controller != null);
	}

}
