package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class Controller {
	
	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	
	int getWidth() {
		return this.session.getWidth();
	}

	public abstract void control();

}
