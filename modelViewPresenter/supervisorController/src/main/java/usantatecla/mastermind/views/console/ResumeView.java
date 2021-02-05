package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView implements usantatecla.mastermind.views.ResumeView {

    public boolean read(){
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();
    }

}
