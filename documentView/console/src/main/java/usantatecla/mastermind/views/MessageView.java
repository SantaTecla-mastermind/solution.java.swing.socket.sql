package usantatecla.mastermind.views;

import usantatecla.utils.Console;

enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET_COMBINATION("****"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-(");

	private String message;

	MessageView(String message) {
		this.message = message;
	}

	void write() {
		Console.getInstance().write(this.message);
	}

	void writeln() {
		Console.getInstance().writeln(this.message);
	}

	void writeln(int attempts) {
		Console.getInstance().writeln(this.message.replaceFirst("#attempts", "" + attempts));
	}

	void writeln(int blacks, int whites) {
		Console.getInstance().writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
	}

}
