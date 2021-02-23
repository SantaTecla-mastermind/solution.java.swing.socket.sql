package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

class ProposeCommand extends Command {

	ProposeCommand(PlayController playController) {
		super(Message.PROPOSE_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.add(new ProposedCombinationView().read(this.playController));
		super.execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
