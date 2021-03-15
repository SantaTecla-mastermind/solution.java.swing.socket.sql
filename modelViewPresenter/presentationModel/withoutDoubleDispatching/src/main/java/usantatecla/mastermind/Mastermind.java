package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
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
		do {
			if (logic.getController() instanceof StartController) {
				this.view.start((StartController) logic.getController());
			} else {
				if (logic.getController() instanceof PlayController) {
					this.view.play((PlayController) logic.getController());
				} else {
					this.view.resume((ResumeController) logic.getController());
				}
			}
		} while (logic.getController() != null);
	}

}
