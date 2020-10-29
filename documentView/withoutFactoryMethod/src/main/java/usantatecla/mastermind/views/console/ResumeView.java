package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {
	
	private Game game;
	
	ResumeView (Game game){
		this.game = game;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
		if (newGame) {
			this.game.reset();
		}
		return newGame;
	}

}
