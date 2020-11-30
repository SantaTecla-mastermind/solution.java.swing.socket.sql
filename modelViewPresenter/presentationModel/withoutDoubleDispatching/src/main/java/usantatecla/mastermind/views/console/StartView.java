package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class StartView extends Console {

	private SecretCombinationView secretCombinationView;

	void interact(StartController startController) {
		startController.start();
		Console.getInstance().writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
