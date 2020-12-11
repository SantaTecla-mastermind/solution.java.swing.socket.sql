package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.YesNoDialog;

class ResumeView extends WithLogicView {

    ResumeView(Logic logic) {
        super(logic);
    }

    boolean interact() {
        boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
            this.logic.clearGame();
        }
        return newGame;
    }

}
