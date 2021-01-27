package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView {

    private ResumeController resumeController;

    ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    public boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.resumeController.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
