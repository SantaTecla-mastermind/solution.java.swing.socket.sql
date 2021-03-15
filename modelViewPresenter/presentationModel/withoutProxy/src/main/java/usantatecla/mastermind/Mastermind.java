package usantatecla.mastermind;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic(this.isStandalone());
		this.view = this.createView();
	}

	protected abstract View createView();

	protected abstract Boolean isStandalone();

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null)
				acceptorController.accept(this.view);
		} while (acceptorController != null);
		if (!this.isStandalone()) {
			this.logic.close();
		}
	}

}
