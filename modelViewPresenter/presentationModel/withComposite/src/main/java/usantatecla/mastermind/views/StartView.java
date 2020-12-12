package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.Console;

class StartView {

	void interact(StartController startController) {
		startController.start();
		Console.getInstance().writeln(Message.TITLE.getMessage());
		new SecretCombinationView(startController).writeln();
	}

}
