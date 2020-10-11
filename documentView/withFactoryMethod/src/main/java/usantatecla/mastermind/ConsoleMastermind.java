package usantatecla.mastermind;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	@Override
	protected View createView(Game game) {
		return new ConsoleView(game);
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
	
}
