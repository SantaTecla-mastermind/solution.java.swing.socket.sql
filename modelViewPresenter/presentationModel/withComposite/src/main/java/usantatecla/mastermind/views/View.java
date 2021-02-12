package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.*;

public abstract class View implements ControllersVisitor {

	public void interact(Logic logic) {
		AcceptorController acceptorController;
		do {
			acceptorController = logic.getController();
			if (acceptorController != null)
				acceptorController.accept(this);
		} while (acceptorController != null);
	}
	
}
