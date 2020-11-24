package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class ResultView extends Console {

	private Logic logic;

	ResultView(Logic logic) {
		this.logic = logic;
	}

	void writeln(int i) {
		Console.getInstance().writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.logic.getBlacks(i))
						.replaceFirst("#whites", "" + this.logic.getWhites(i)));
	}

}
