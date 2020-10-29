package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.SecretCombination;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {

	SecretCombinationView() {
		super();
	}

	void writeln() {
		for (int i = 0; i < SecretCombination.getWidth(); i++) {
			this.console.write(Message.SECRET.getMessage());
		}
		this.console.writeln();
	}

}
