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
            this.board.add(new ProposedCombinationView().read(this.board));
            new BoardView().write(this.board);
        } while (!this.board.isFinished());
        Message message = Message.LOOSER;
        if (this.board.isWinner()){
            message = Message.WINNER;
        }
        new MessageView().writeln(message);
    }

}
