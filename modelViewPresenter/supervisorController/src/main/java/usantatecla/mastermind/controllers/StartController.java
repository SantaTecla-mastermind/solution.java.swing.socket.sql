package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.StartView;

public class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		this.session.next();
		new StartView(this.session.getGame()).write();
	}

}
