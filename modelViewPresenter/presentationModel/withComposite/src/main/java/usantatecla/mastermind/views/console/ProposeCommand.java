package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Command;
import usantatecla.mastermind.views.Message;

// TODO Los command podrían ir en el paquete views. ¿Hacer interfaces de las vistas que usan?
class ProposeCommand extends Command {

	ProposeCommand(PlayController playController) {
		super(Message.PROPOSE_COMMAND.toString(), playController);
	}

	@Override
	protected void execute() {
		this.playController.add(new ProposedCombinationView().read(this.playController));
		new BoardView().write(this.playController);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
