package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Command;
import usantatecla.mastermind.views.Message;

class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.toString(), playController);
	}

	@Override
	protected void execute() {
		this.playController.undo();
		new BoardView().write(this.playController);
	}

	@Override
	protected boolean isActive() {
		return this.playController.undoable();
	}
	
}
