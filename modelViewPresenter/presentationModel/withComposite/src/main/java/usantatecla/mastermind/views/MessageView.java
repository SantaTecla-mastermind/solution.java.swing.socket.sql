package usantatecla.mastermind.views;

import usantatecla.utils.Console;

enum MessageView {
	ATTEMPTS("#attempts attempt(s): "), 
	SECRET("*"), 
	RESUME("Do you want to continue"), 
	RESULT(" --> #blacks blacks and #whites whites"), 
	PROPOSED_COMBINATION("Propose a combination: "), 
	TITLE("----- MASTERMIND -----"), 
	WINNER("You've won!!! ;-)"), 
	LOOSER("You've lost!!! :-("), 
	PROPOSE_COMMAND("Propose Combination"), 
	UNDO_COMMAND("Undo previous Proposal"), 
	REDO_COMMAND("Redo previous Proposal"), 
	NEW_LINE("");

	private String message;

	private MessageView(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void writeln() {
		Console.getInstance().writeln(this.message);
	}

	public void writeln(int attempts) {
		Console.getInstance().writeln(this.message.replaceAll("#attempts", "" + attempts));
	}

	public void writeln(int blacks, int whites) {
		Console.getInstance().writeln(this.message.replaceAll("#blacks", "" + blacks).replaceAll("#whites", "" + whites));
	}

	public void write() {
		Console.getInstance().write(this.message);
	}

}
