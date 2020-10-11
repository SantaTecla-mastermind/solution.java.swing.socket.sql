package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Mastermind;
import usantatecla.utils.Observer;

abstract class Command extends usantatecla.utils.Command {
	
	protected Mastermind mastermind;
	
	protected Command(String title, Mastermind mastermind, Observer observer) {
		this.title = title;
		this.mastermind = mastermind;
		this.addObserver(observer);
	}

}
