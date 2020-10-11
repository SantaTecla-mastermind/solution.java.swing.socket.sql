package usantatecla.mastermind;

import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	protected View createView() {
		return new ConsoleView();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
