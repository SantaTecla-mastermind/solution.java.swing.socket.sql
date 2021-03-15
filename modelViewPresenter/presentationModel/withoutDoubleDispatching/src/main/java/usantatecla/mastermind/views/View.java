package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;

public interface View {

	void start(StartController startController);
	void play(PlayController playController);
	boolean resume(ResumeController resumeController);
	
}
