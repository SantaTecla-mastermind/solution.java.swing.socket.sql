package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

public abstract class Command extends usantatecla.utils.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}
	
}
