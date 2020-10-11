package usantatecla.mastermind.views.menus;

import usantatecla.mastermind.controllers.AcceptorController;

abstract class Command extends usantatecla.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
