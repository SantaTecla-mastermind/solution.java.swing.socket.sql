package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

public class ErrorView extends usantatecla.mastermind.views.ErrorView {

	ErrorView() {
	}

	public ErrorView(Error error) {
		super(error);
	}

	public void writeln() {
		if (!this.error.isNull()) {
			Console.getInstance().writeln(new ErrorView().MESSAGES[this.error.ordinal()]);
		}
	}

	@Override
	protected String colorInitials() {
		return new ColorView().allInitials();
	}
}
