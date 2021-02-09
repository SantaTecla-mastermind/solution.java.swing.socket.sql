package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Logic logic) {
        Console.getInstance().writeln();
        int attempts = logic.getAttempts();
        new MessageView().writeln(Message.ATTEMPTS, attempts);
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(logic.getProposedCombinationColors(i));
            new MessageView().writeln(Message.RESULT, logic.getBlacks(i), logic.getWhites(i));
        }
    }

}
