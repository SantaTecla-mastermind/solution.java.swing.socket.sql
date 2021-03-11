package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.Logic;

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
