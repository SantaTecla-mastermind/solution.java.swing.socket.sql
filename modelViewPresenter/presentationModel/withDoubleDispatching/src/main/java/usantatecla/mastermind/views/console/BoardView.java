package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Controller controller) {
        Console.getInstance().writeln();
        int attempts = controller.getAttempts();
        new MessageView().writeln(Message.ATTEMPTS, attempts);
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(controller.getProposedCombinationColors(i));
            new MessageView().writeln(Message.RESULT, controller.getBlacks(i), controller.getWhites(i));
        }
    }

}
