package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {
	
	private int attempts;

	AttemptsView(int attempts){
		this.attempts = attempts;
	}
	
	void writeln() {
		this.console.writeln(Message.ATTEMPTS.getMessage().replace("#attempts", ""+this.attempts));
	}
}
