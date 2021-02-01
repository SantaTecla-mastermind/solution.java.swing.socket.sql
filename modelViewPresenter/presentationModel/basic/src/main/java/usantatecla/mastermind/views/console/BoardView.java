package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    void write(Controller controller) {
        Console.getInstance().writeln();
        int attempts = controller.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(controller.getProposedCombinationColors(i));
            Message.RESULT.writeln(controller.getBlacks(i), controller.getWhites(i));
        }
    }

}
