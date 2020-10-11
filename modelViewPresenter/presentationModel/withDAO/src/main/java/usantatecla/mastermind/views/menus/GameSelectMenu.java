package usantatecla.mastermind.views.menus;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.Menu;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
