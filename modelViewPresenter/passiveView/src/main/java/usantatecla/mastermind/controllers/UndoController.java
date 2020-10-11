package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

class UndoController extends InGameController {

	UndoController(Session session) {
		super(session);
	}

	boolean undoable() {
		return this.session.undoable();
	}

	@Override
	public void inGameControl() {
		this.session.undo();
	}

}
