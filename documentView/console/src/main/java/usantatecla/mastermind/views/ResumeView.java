package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;
import usantatecla.utils.YesNoDialog;

class ResumeView extends WithGameView {

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.game.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
