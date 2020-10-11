package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.Command;

public class UndoCommand extends Command {

	public UndoCommand(Session session) {
		super(MessageView.UNDO_COMMAND.getMessage(), session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.session.undoable();
	}
	
}
