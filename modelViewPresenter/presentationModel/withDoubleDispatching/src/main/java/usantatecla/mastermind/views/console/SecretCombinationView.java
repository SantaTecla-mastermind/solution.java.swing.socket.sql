package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class SecretCombinationView extends Console {
	
	private Controller controller;
	
	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	public void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			Console.getInstance().write(MessageView.SECRET.getMessage());
		}
		Console.getInstance().writeln();
	}
	
}
