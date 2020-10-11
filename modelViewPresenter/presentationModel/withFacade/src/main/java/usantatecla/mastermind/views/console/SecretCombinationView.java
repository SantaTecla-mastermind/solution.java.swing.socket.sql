package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private Logic logic;
	
	SecretCombinationView (Logic logic){
		this.logic = logic;
	}
	
	void writeln() {
		for (int i = 0; i < this.logic.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
