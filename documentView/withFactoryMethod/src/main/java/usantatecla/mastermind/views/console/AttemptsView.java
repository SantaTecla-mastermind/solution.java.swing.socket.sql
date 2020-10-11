package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

	private Game game;

	AttemptsView(Game game) {
		this.game = game;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replace("#attempts", "" + this.game.getAttempts()));
	}
}
