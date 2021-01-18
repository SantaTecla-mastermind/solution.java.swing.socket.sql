package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.utils.Console;

class BoardView {

    void write(Board board) {
        Console.getInstance().writeln();
        int attempts = board.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView().write(board.getProposedCombination(i));
            Message.RESULT.writeln(board.getResult(i).getBlacks(), board.getResult(i).getWhites());
        }
    }

}
