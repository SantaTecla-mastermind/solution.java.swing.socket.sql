package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

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
        message.writeln();
    }
}
