package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView(this.game).write();
    }

}
