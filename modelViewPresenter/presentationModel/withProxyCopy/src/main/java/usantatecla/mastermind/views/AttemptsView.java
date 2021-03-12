package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

class AttemptsView {

	private PlayController playController;

	AttemptsView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.playController.getAttempts());
	}

}
