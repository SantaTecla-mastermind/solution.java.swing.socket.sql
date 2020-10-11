package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
