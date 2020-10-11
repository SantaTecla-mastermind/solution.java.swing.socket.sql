package usantatecla.mastermind.views;

import usantatecla.mastermind.events.LostGameEvent;
import usantatecla.mastermind.events.NewGameEvent;
import usantatecla.mastermind.events.WonGameEvent;
import usantatecla.mastermind.models.Mastermind;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;
import usantatecla.utils.YesNoDialog;

public class MastermindView extends Observed implements Observer{

	private Mastermind mastermind;

	private Menu menu;

	public MastermindView(Mastermind mastermind, Observer observer) {
		this.mastermind = mastermind;
		this.menu = new Menu(mastermind, observer);
	}

	public void write() {
		MessageView.TITLE.writeln();
		new SecretCombinationView(this.mastermind.getSecretCombination()).writeln();
		do {
			this.menu.execute();
		} while (!this.mastermind.isWinner() && !this.mastermind.isLooser());
	}

	
	public void update(Observed observed, Event event) {
		if (event instanceof WonGameEvent) {
			MessageView.WINNER.writeln();
			this.resume();
		} else if (event instanceof LostGameEvent) {
			MessageView.LOOSER.writeln();
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(MessageView.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}

}
