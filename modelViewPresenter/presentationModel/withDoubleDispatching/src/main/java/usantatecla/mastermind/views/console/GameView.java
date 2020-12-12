package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class GameView {

    private ProposalController proposalController;

    GameView(ProposalController proposalController) {
        this.proposalController = proposalController;
    }

    void write() {
        Console.getInstance().writeln();
        new AttemptsView(proposalController).writeln();
        new SecretCombinationView(proposalController).writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController).write(i);
            new ResultView(proposalController).writeln(i);
        }

        if (proposalController.isWinner()) {
            Console.getInstance().writeln(Message.WINNER.getMessage());
        } else if (proposalController.isLooser()) {
            Console.getInstance().writeln(Message.LOOSER.getMessage());
        }
    }

}
