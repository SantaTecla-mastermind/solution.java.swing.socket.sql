package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    void write(Logic logic) {
        Console.getInstance().writeln();
        int attempts = logic.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(logic.getProposedCombinationColors(i));
            Message.RESULT.writeln(logic.getBlacks(i), logic.getWhites(i));
        }
    }

}
