package usantatecla.mastermind.views;

import usantatecla.utils.YesNoDialog;

public class ResumeView {

	public Boolean write() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
