package usantatecla.mastermind.views;

import usantatecla.mastermind.events.RedoEvent;
import usantatecla.mastermind.models.Mastermind;
import usantatecla.mastermind.views.Command;
import usantatecla.utils.Observer;

public class RedoCommand extends Command{
	
	RedoCommand(Mastermind mastermind, Observer observer) {
		super(MessageView.REDO_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.mastermind.redoable();
	}

	@Override
	public void execute() {
		this.notify(new RedoEvent());		
	}

}
