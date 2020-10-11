package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

class RedoController extends InGameController {

	RedoController(Session session) {
		super(session);
	}

	boolean redoable() {
		return this.session.redoable();
	}

	@Override
	public void inGameControl() {
		this.session.redo();
	}

}
