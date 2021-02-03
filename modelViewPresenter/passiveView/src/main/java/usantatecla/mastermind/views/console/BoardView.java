package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView extends usantatecla.mastermind.views.BoardView {

    public void write(){
        Console.getInstance().writeln();
        int attempts = this.attempts;
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(this.proposedCombinationColors.get(i));
            Message.RESULT.writeln(controller.getBlacks(i), controller.getWhites(i));
        }
    }

}
