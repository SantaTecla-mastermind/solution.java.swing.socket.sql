package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;

class PlayView extends WithBoardView {

    PlayView(Board board) {
        super(board);
    }

    void interact() {
        do {
            this.board.add(new ProposedCombinationView(new ProposedCombination()).read());
            new BoardView(this.board).write();
        } while (!this.board.isFinished());

        if(this.board.isWinner()){
            Message.WINNER.writeln();
        } else {
            Message.LOOSER.writeln();
        }
    }

}
