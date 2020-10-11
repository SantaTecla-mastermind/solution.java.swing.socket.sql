package usantatecla.mastermind;

import java.util.HashMap;
import java.util.Map;
import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

public class Mastermind {

	private Session session;

	private Map<StateValue, Controller> controllers;

	private Mastermind() {
		this.session = new Session();
		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
		this.controllers.put(StateValue.EXIT, null);
	}

	private void play() {
		Controller controller;
		do {
			controller = this.controllers.get(this.session.getValueState());
			if (controller != null) {
				controller.control();
			}
		} while (controller != null);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
