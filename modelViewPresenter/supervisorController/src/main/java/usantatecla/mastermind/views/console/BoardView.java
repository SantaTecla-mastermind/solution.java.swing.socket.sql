package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView implements usantatecla.mastermind.views.BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void write(){
        Console.getInstance().writeln();
        new MessageView().writeln(Message.ATTEMPTS, this.board.getAttempts());
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < this.board.getAttempts(); i++) {
            new ProposedCombinationView(this.board.getProposedCombination(i)).write();
            new MessageView().writeln(Message.RESULT, this.board.getBlacks(i), this.board.getWhites(i));
        }
    }

}
