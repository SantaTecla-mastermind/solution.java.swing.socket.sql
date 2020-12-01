package usantatecla.mastermind.views;

import usantatecla.utils.Console;

class StartView {

	void interact() {
		Console.getInstance().writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln();
	}

}
