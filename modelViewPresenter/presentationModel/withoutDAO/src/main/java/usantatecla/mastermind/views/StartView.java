package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.menus.StartMenu;
import usantatecla.mastermind.views.models.GameView;
import usantatecla.mastermind.views.models.MessageView;

class StartView {
	
	void interact(StartController startController) {
		MessageView.TITLE.writeln();
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
