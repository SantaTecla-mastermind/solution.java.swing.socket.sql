package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

	public StartControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();		
	}

}
