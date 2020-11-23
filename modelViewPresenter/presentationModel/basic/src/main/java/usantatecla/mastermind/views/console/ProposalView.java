package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.models.Color;
import usantatecla.mastermind.models.Error;

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
        Error error = Error.NULL;
        do {
            List<Color> colors = this.proposedCombinationView.read();
            error = this.proposalController.addProposedCombination(colors);
            if (!error.isNull()) {
                new ErrorView(error).writeln();
            }
        } while(!error.isNull());

        this.gameView.write();
        return this.gameView.isWinnerOrLooser();
    }

}
