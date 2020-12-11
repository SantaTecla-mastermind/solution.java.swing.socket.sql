package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.WithLogicView;

import java.util.List;

class ProposalView extends WithLogicView {

    private ProposedCombinationView proposedCombinationView;
    private GameView gameView;

    ProposalView(Logic logic) {
        super(logic);
        this.proposedCombinationView = new ProposedCombinationView(this.logic);
        this.gameView = new GameView(this.logic, this.proposedCombinationView);
    }

    boolean interact() {
        Error error;
        do {
            List<Color> colors = this.proposedCombinationView.read();
            error = this.logic.addProposedCombination(colors);
            if (error != Error.NULL) {
                new ErrorView(error).writeln();
            }
        } while (error != Error.NULL);

        this.gameView.write();
        return this.gameView.isWinnerOrLooser();
    }

}
