package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

class RedoController extends Controller {

	RedoController(Session session) {
		super(session);
	}

	void redo() {
		this.session.redo();
	}

	boolean redoable() {
		return this.session.redoable();
	}

}
