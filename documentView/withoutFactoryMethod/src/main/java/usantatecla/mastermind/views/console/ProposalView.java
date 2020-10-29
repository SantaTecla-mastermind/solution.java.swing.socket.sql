package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.WithConsoleView;

class ProposalView extends WithConsoleView {
	
	private Game game;
	
	private SecretCombinationView secretCombinationView;
	
	ProposalView (Game game){
		this.game = game;
		this.secretCombinationView = new SecretCombinationView();
	}

	boolean interact() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		this.game.addProposedCombination(proposedCombination);

		// TODO ¿GameView para todo esto de pintar?
		this.console.writeln();
		new AttemptsView(this.game.getAttempts()).writeln();
		this.secretCombinationView.writeln();
		for (int i = 0; i < this.game.getAttempts(); i++) {
			new ProposedCombinationView(this.game.getProposedCombination(i)).write();
			new ResultView(this.game.getResult(i)).writeln();
		}

		if (this.game.isWinner()) {
			this.console.writeln(Message.WINNER.getMessage());
			return true;
		} else if (this.game.isLooser()) {
			this.console.writeln(Message.LOOSER.getMessage());
			return true;

		}
		return false;
	}

}
