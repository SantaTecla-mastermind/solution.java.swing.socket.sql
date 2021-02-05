package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithBoardView;

class PlayView extends WithBoardView {

    PlayView(Board board) {
        super(board);
    }

    void interact() {
        do {
            this.board.add(new ProposedCombinationView().read());
            new BoardView().write(this.board);
        } while (!this.board.isFinished());
        if (this.board.isWinner()) {
            new MessageView().writeln(Message.WINNER);
        } else {
            new MessageView().writeln(Message.LOOSER);
        }
    }

}
