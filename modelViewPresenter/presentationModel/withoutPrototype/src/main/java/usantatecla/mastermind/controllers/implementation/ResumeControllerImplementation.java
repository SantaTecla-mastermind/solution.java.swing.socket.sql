package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

	ResumeControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void isNewGame(boolean newGame) {
		if (newGame) {
			((SessionImplementation) this.session).isNewGame();
		} else {
			((SessionImplementation) this.session).next();
		}
	}

}
