package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

public class SecretCombinationView {
	
	private final Controller controller;
	
	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	public void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			Console.getInstance().write(Message.SECRET.getMessage());
		}
		Console.getInstance().writeln();
	}
	
}
