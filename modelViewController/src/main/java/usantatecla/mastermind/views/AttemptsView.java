package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

class AttemptsView {

	private Game game;

	AttemptsView(Game game) {
		this.game = game;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.game.getAttempts());
	}

}
