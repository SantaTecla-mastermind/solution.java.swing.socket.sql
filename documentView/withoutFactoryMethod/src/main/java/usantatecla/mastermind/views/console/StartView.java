package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact() {
		this.console.writeln(Message.TITLE.getMessage());
		new SecretCombinationView().writeln();
	}

}
