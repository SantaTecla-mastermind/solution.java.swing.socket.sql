package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

class ProposalView {

    private ProposalController proposalController;
    private ProposedCombinationView proposedCombinationView;
    private GameView gameView;

    ProposalView(ProposalController proposalController) {
        this.proposalController = proposalController;
        this.proposedCombinationView = new ProposedCombinationView(proposalController);
        this.gameView = new GameView(proposalController, this.proposedCombinationView);
    }

    boolean interact() {
        Error error;
        do {
            List<Color> colors = this.proposedCombinationView.read();
            error = this.proposalController.addProposedCombination(colors);
            if (!error.isNull()) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());

        this.gameView.write();
        return this.gameView.isWinnerOrLooser();
    }

}
