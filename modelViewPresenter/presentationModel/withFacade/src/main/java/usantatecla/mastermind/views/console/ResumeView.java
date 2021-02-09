package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.views.YesNoDialog;

class ResumeView extends WithLogicView {

    ResumeView(Logic logic) {
        super(logic);
    }

    boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.logic.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
