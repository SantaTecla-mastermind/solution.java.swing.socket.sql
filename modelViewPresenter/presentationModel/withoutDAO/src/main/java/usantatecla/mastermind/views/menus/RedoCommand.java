package usantatecla.mastermind.views.menus;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.models.MessageView;

class RedoCommand extends Command{
	
	RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).redo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).redoable();
	}

}
