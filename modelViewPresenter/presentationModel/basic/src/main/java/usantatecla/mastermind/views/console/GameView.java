package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class GameView {

    private ProposalController proposalController;
    private ProposedCombinationView proposedCombinationView;
    private SecretCombinationView secretCombinationView;
    private ResultView resultView;

    GameView(ProposalController proposalController, ProposedCombinationView proposedCombinationView) {
        this.proposalController = proposalController;
        this.proposedCombinationView = proposedCombinationView;
        this.secretCombinationView = new SecretCombinationView(this.proposalController);
        this.resultView = new ResultView(this.proposalController);
    }

    void write() {
        Console.getInstance().writeln();
        new AttemptsView(this.proposalController.getAttempts()).writeln();
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.proposalController.getAttempts(); i++) {
            this.proposedCombinationView.write(i);
            this.resultView.writeln(i);
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
