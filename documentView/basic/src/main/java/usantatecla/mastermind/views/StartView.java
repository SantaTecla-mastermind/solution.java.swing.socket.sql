package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

class StartView extends WithBoardView {

    StartView(Board board) {
        super(board);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.board);
    }

}
