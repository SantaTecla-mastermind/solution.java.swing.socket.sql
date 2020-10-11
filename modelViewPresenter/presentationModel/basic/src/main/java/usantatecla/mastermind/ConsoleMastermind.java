package usantatecla.mastermind;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind {

	@Override
	protected View createView(StartController startController, ProposalController proposalController,
			ResumeController resumeController) {
		return new ConsoleView(startController, proposalController, resumeController);
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}

}
