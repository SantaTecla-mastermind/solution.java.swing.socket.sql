package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class GameView {

    private ProposalController proposalController;
    private SecretCombinationView secretCombinationView;

    GameView(ProposalController proposalController) {
        this.proposalController = proposalController;
        this.secretCombinationView = new SecretCombinationView(this.proposalController);
    }

    void write() {
        Console.getInstance().writeln();
        new AttemptsView(this.proposalController.getAttempts()).writeln();
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.proposalController.getAttempts(); i++) {
            new ProposedCombinationView(this.proposalController.getProposedCombination(i)).write();
            new ResultView(this.proposalController.getResult(i)).writeln();
        }
    }

    boolean isWinnerOrLooser() {
        if (this.proposalController.isWinner()) {
            Console.getInstance().writeln(Message.WINNER.getMessage());
            return true;
        } else if (this.proposalController.isLooser()) {
            Console.getInstance().writeln(Message.LOOSER.getMessage());
            return true;
        }
        return false;
    }
}
