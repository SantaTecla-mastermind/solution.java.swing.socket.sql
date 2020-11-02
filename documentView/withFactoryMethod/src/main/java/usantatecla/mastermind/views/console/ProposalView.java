package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;

class ProposalView {

	private Game game;

	private GameView gameView;

	ProposalView (Game game){
		this.game = game;
		this.gameView = new GameView(game);
	}

	boolean interact() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		this.game.addProposedCombination(proposedCombination);

		this.gameView.write();

		return this.gameView.isWinnerOrLooser();
	}

}
