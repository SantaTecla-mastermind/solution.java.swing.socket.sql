package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;

class ProposalView extends WithGameView {

    private GameView gameView;

    ProposalView(Game game) {
        super(game);
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
