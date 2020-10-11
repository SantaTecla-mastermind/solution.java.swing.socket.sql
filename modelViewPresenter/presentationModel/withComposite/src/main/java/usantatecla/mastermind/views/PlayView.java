package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

class PlayView {

	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
	}

}
