package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView extends usantatecla.mastermind.views.BoardView {

    @Override
    public void write(){
        Console.getInstance().writeln();
        new MessageView().writeln(Message.ATTEMPTS, this.attempts);
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < this.attempts; i++) {
            new ProposedCombinationView().write(this.proposedCombinationColors.get(i));
            new MessageView().writeln(Message.RESULT, this.blacks.get(i), this.whites.get(i));
        }
    }

}
