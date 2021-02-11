package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

public abstract class Command extends usantatecla.utils.models.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}
	
}
