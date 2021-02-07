package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Board board) {
        Console.getInstance().writeln();
        int attempts = board.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(board.getProposedCombinationColors(i));
            Message.RESULT.writeln(board.getBlacks(i), board.getWhites(i));
        }
    }

}
