package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.menus.PlayMenu;
import usantatecla.mastermind.views.models.GameView;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
		new GameView(playController).writeln();
	}

}
