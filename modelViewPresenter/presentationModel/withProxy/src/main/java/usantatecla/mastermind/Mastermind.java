package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private View view;
	private Logic logic;

	protected Mastermind() {
		this.logic = new Logic(new Session(), this.isStandalone());
		this.view = this.createView();
	}

	protected abstract View createView();

	protected abstract Boolean isStandalone();

	protected void play() {
		this.view.interact(this.logic);
		if (!this.isStandalone()) {
			this.logic.close();
		}
	}

}
