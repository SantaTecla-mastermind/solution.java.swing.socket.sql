package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;

public abstract class Command extends usantatecla.utils.models.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}

	@Override
	public void execute() {
		new BoardView().write(this.playController);
	}
	
}
