package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public void interact(Controller controller) {
		controller.accept(this);
	}

}
