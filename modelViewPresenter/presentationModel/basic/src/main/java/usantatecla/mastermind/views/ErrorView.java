package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Error;

public abstract class ErrorView {

	public final String[] MESSAGES = {
			"Repeated colors",
			"Wrong colors, they must be: " + this.colorInitials(),
			"Wrong proposed combination length" };

	protected Error error;

	protected ErrorView() { }

	public ErrorView(Error error) {
		this.error = error;
	}

	protected abstract String colorInitials();
}
