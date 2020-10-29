package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	private Result result;

	ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		this.console.writeln(Message.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
				.replaceFirst("#whites", "" + this.result.getWhites()));
	}

}
