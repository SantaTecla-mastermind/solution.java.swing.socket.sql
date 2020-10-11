package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;

public abstract class Controller {

	protected Game game;

	Controller(Game game) {
		this.game = game;
	}

	int getWidth() {
		return this.game.getWidth();
	}

}
