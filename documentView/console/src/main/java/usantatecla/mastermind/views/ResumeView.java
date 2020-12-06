package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;
import usantatecla.utils.YesNoDialog;

class ResumeView extends WithGameView {

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        Console.getInstance().write(Message.RESUME.getMessage());
        boolean newGame = new YesNoDialog().read();
        if (newGame) {
            this.game.reset();
        }
        return newGame;
    }

}
