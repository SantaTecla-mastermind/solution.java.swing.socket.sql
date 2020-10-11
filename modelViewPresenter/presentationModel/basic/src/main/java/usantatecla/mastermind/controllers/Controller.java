package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.Game;

public abstract class Controller {

	protected Game game;

	Controller(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

}
