package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private StartController startController;
	
	private SecretCombinationView secretCombinationView;
	
	StartView (StartController startController){
		this.startController = startController;
		this.secretCombinationView = new SecretCombinationView(this.startController);
	}

	void interact() {
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView.writeln();
	}

}
