package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.Command;

public class ProposeCommand extends Command {

	public ProposeCommand(Session session) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

}
