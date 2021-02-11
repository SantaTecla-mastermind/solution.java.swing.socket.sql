package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Command;
import usantatecla.mastermind.views.Message;

class RedoCommand extends Command {
	
	RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.toString(), playController);
	}

	@Override
	protected void execute() {
		this.playController.redo();
		new BoardView().write(this.playController);
	}

	@Override
	protected boolean isActive() {
		return this.playController.redoable();
	}

}
