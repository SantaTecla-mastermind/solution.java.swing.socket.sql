package usantatecla.mastermind.views;

import usantatecla.utils.Console;

class SecretCombinationView {

	SecretCombinationView() {
		super();
	}

	void writeln() {
		MessageView.SECRET_COMBINATION.write();
		Console.getInstance().writeln();
	}

}
