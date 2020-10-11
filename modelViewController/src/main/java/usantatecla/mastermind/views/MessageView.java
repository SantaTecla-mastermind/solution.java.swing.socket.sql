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
	
	private Console console;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	String getMessage() {
		return this.message;
	}
	
	void write() {
		System.out.print(this.message);
	}
	
	void writeln() {
		System.out.println(this.message);
	}
	
	void writeln(int attempts) {
		System.out.println(this.message.replaceAll("#attempts", ""+attempts));
	}
	
	void writeln(int blacks, int whites) {
		System.out.println(this.message.replaceAll("#blacks", ""+blacks).replaceAll("#whites", ""+whites));
	}

}
