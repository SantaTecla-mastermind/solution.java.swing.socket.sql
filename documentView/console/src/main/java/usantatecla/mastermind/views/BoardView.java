package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.utils.Console;

class BoardView extends WithBoardView {

    BoardView(Board board) {
        super(board);
    }

    void write() {
        Console.getInstance().writeln();
        int attempts = this.board.getAttempts();
        Message.ATTEMPTS.writeln(attempts);
        Message.SECRET_COMBINATION.writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView(this.board.getProposedCombination(i)).write();
            Message.RESULT.writeln(this.board.getResult(i).getBlacks(), this.board.getResult(i).getWhites());
        }
    }

}
