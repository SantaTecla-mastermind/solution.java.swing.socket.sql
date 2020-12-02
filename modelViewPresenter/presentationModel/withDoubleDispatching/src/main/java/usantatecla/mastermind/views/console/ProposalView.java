package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;
import usantatecla.mastermind.views.MessageView;

public class ProposalView extends Console {

	public void interact(ProposalController proposalController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(proposalController).read();
			error = proposalController.addProposedCombination(colors);
			if (!error.isNull()) {
				new ErrorView(error).writeln();
			}
		} while (!error.isNull());
		Console.getInstance().writeln();
		new AttemptsView(proposalController).writeln();
		new SecretCombinationView(proposalController).writeln();
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView(proposalController).write(i);
			new ResultView(proposalController).writeln(i);
		}
		if (proposalController.isWinner()) {
			Console.getInstance().writeln(MessageView.WINNER.getMessage());
		} else if (proposalController.isLooser()) {
			Console.getInstance().writeln(MessageView.LOOSER.getMessage());
		}
	}

}
