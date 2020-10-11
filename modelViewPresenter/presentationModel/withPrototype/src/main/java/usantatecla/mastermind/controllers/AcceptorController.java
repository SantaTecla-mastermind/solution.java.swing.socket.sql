package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class AcceptorController extends Controller {

	AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

}
