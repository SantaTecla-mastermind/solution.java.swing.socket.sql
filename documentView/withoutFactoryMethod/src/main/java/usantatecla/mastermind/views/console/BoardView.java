package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView { // TODO package private

    void write(Board board) {
        Console.getInstance().writeln();
        int attempts = board.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(board.getProposedCombination(i));
            Message.RESULT.writeln(board.getBlacks(i), board.getWhites(i));
        }
    }

}
