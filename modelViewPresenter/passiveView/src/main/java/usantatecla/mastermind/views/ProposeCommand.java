package usantatecla.mastermind.views;

import usantatecla.utils.Command;

public class ProposeCommand extends Command {

	public ProposeCommand() {
		super(MessageView.PROPOSE_COMMAND.getMessage());
	}

	@Override
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
