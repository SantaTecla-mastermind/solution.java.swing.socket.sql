package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.utils.Console;

class SecretCombinationView {

	private Controller controller;

	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}

	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			Console.getInstance().write(Message.SECRET.getMessage());
		}
		Console.getInstance().writeln();
	}

}
