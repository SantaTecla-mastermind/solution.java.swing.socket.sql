package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private Logic logic;

	AttemptsView(Logic logic) {
		this.logic = logic;
	}

	void writeln() {
		this.console
				.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.logic.getAttempts()));
	}

}
