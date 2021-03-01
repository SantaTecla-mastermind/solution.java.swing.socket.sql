package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermindClient extends Mastermind {

	@Override
	protected ConsoleView createView() {
		return new ConsoleView();
	}

	@Override
	protected Boolean isStandalone() {
		return false;
	}
	
	public static void main(String[] args) {
		new ConsoleMastermindClient().play();
	}

}
