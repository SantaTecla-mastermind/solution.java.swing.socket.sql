package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		((SessionImplementation) this.session).next();
	}

}
