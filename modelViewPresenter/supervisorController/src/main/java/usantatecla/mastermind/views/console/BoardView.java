package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView extends usantatecla.mastermind.views.BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void write(){
        Console.getInstance().writeln();
        int attempts = this.attempts;
        new MessageView().writeln(Message.ATTEMPTS, attempts);
        new MessageView().writeln(Message.SECRET_COMBINATION);
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView(new ProposedCombination(this.board.getProposedCombinationColors(i))).write();
            new MessageView().writeln(Message.RESULT, this.blacks.get(i), this.whites.get(i));
        }
    }

}
