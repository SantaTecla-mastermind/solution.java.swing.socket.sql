package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    private PlayController playController;
    private ProposedCombinationView proposedCombinationView;

    BoardView(PlayController playController, ProposedCombinationView proposedCombinationView) {
        this.playController = playController;
        this.proposedCombinationView = proposedCombinationView;
    }

    void write() {
        Console.getInstance().writeln();
        int attempts = this.playController.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(this.playController.getProposedCombination(i));
            Message.RESULT.writeln(this.playController.getBlacks(i), this.playController.getWhites(i));
        }
    }

}
