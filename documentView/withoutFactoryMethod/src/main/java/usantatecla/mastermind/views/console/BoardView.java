package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Board board) {
        Console.getInstance().writeln();
        int attempts = board.getAttempts();
        new MessageView().writeln(Message.ATTEMPTS, attempts);
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(board.getProposedCombinationColors(i));
            new MessageView().writeln(Message.RESULT, board.getBlacks(i), board.getWhites(i));
        }
    }

}
