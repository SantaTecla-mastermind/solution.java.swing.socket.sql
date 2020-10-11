package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		if (new ResumeView().write()) {
			this.session.clearGame();
		} else {
			this.session.next();
		}
	}

}
