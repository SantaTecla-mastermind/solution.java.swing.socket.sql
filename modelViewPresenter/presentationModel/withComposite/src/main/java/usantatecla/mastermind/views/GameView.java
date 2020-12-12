package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Console;

class GameView {

	GameView(PlayController playController) {
		Console.getInstance().writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}

		if (playController.isWinner()) {
			Console.getInstance().writeln(Message.WINNER.getMessage());
		} else if (playController.isLooser()) {
			Console.getInstance().writeln(Message.LOOSER.getMessage());
		}
	}
	
}
