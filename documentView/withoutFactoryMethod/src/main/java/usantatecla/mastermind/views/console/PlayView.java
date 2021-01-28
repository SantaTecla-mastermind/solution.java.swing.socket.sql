package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithBoardView;

// TODO clase y métodos package private
public class PlayView extends WithBoardView {

    public PlayView(Board board) {
        super(board);
    }

    public void interact() {
        do {
            this.board.add(new ProposedCombinationView().read());
            new BoardView().write(this.board);
        } while (!this.board.isFinished());
        if(this.board.isWinner()){
            Message.WINNER.writeln();
        } else {
            Message.LOOSER.writeln();
        }
    }
}
