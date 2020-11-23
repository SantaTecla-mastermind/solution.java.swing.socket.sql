package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.models.ProposedCombination;

class ProposalView {

    private ProposalController proposalController;

    private GameView gameView;

    ProposalView(ProposalController proposalController) {
        this.proposalController = proposalController;
        this.gameView = new GameView(proposalController);
    }

    boolean interact() {
        ProposedCombination proposedCombination = new ProposedCombination();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
        proposedCombinationView.read();
        this.proposalController.addProposedCombination(proposedCombination);

        this.gameView.write();

        return this.gameView.isWinnerOrLooser();
    }

}
