package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.views.Menu;

class PlayMenu extends Menu {

	PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
	}

}
