package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

public class StartView {

	private SecretCombinationView secretCombinationView;

	public void interact(StartController startController) {
		startController.start();
		Console.getInstance().writeln(Message.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
