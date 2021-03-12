package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

	public ResumeControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void resume(boolean newGame) {
		if (newGame) {
			((SessionImplementation) this.session).clearGame();
		} else {
			((SessionImplementation) this.session).next();
		}
	}

}
