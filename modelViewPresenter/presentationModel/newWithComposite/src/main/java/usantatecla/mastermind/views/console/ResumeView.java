package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            resumeController.reset();
        }else{
            resumeController.nextState();
        }
        return yesNoDialog.isAffirmative();
    }

}
