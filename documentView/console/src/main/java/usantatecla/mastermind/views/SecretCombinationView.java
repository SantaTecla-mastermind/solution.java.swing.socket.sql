package usantatecla.mastermind.views;

import usantatecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {

	SecretCombinationView() {
		super();
	}

	void writeln() {
		MessageView.SECRET_COMBINATION.write();
		this.console.writeln();
	}

}
