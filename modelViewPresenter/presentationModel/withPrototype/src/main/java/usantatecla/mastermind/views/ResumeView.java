package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.models.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.isNewGame(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
