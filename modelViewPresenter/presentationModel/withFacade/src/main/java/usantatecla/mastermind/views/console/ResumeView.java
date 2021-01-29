package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView {

    private Logic logic;

    ResumeView(Logic logic) {
        this.logic = logic;
    }

    public boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.logic.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
