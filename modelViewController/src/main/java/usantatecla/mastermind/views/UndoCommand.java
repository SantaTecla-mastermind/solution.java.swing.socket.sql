package usantatecla.mastermind.views;

import usantatecla.mastermind.events.UndoEvent;
import usantatecla.mastermind.models.Mastermind;
import usantatecla.mastermind.views.Command;
import usantatecla.utils.Observer;

public class UndoCommand extends Command {

	UndoCommand(Mastermind mastermind, Observer observer) {
		super(MessageView.UNDO_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.mastermind.undoable();
	}

	@Override
	public void execute() {
		this.notify(new UndoEvent());
	}
	
}
