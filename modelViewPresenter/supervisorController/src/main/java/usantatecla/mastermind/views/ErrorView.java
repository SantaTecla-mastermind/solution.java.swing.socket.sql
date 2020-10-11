package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.WithConsoleView;

class ErrorView extends WithConsoleView{

	static final String[] MESSAGES = { 
		"Repeated colors",
		"Wrong colors, they must be: " + ColorView.allInitials(), 
		"Wrong proposed combination length" };

	private Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	
	
}
