package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	@Override
	protected View createView(Logic logic) {
		return new ConsoleView(logic);
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
	
}
