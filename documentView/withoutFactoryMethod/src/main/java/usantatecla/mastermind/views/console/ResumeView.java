package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithGameView;
import usantatecla.utils.YesNoDialog;

class ResumeView extends WithGameView {

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
            this.game.reset();
        }
        return newGame;
    }

}
