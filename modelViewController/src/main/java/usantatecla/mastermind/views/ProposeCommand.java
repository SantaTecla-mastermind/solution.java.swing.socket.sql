package usantatecla.mastermind.views;

import usantatecla.mastermind.events.ProposeEvent;
import usantatecla.mastermind.models.Mastermind;
import usantatecla.mastermind.views.Command;
import usantatecla.utils.Observer;

public class ProposeCommand extends Command {

	ProposeCommand(Mastermind mastermind, Observer observer) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), mastermind, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

	@Override
	public void execute() {
		this.notify(new ProposeEvent());
	}

}
