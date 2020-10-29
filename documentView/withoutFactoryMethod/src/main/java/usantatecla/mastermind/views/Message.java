package usantatecla.mastermind.views;

public enum Message {
	// TODO Revisar diferencia de SECRET y SECRET_COMBINATION de la anterior versión (console)
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private Message(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	// TODO Revisar cómo hacer más consistente el diseño, antes MessageView se encargaba de pintar por consola
}
