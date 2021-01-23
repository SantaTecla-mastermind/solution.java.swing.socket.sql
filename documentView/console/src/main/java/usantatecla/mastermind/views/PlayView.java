package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

class PlayView extends WithBoardView {

    PlayView(Board board) {
        super(board);
    }

    void interact() {
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
