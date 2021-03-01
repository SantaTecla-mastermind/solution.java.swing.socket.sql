package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

class UndoController extends Controller {

	UndoController(Session session) {
		super(session);
	}

	void undo() {
		this.session.undo();
	}

	boolean undoable() {
		return this.session.undoable();
	}

}
