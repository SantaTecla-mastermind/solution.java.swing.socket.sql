package usantatecla.mastermind.views;

import usantatecla.utils.YesNoDialog;

public class ResumeView {

	public boolean write() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
