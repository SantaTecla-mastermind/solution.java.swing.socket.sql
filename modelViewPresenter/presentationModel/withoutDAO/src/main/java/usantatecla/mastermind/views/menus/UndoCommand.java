package usantatecla.mastermind.views.menus;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.models.MessageView;

public class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(MessageView.UNDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).undo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).undoable();
	}
	
}
