package usantatecla.mastermind;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.Logic;
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
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null)
				acceptorController.accept(this.view);
		} while (acceptorController != null);
	}

}
