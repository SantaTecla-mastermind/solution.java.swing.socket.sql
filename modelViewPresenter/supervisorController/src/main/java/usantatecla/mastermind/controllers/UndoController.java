package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

class UndoController extends InGameController {

	UndoController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		this.session.undo();
	}

}
