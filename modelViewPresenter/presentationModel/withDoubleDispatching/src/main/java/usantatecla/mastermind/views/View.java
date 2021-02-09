package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.*;

public abstract class View implements ControllersVisitor {

	public void interact(Logic logic) {
		Controller controller;
		do {
			controller = logic.getController();
			if (controller != null)
				controller.accept(this);
		} while (controller != null);
	}
	
}
