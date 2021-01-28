package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    private Controller controller;
    private ProposedCombinationView proposedCombinationView;

    BoardView(Controller controller, ProposedCombinationView proposedCombinationView) {
        this.controller = controller;
        this.proposedCombinationView = proposedCombinationView;
    }

    void write() {
        Console.getInstance().writeln();
        int attempts = this.controller.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            this.proposedCombinationView.write(this.controller.getProposedCombination(i));
            Message.RESULT.writeln(this.controller.getBlacks(i), this.controller.getWhites(i));
        }
    }

}
