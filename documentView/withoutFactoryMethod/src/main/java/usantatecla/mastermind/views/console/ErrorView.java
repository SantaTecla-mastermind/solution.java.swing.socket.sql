package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Error;
import usantatecla.utils.Console;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		Console.getInstance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
