package usantatecla.mastermind;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

	private final View view;

	protected Mastermind() {
		this.view = this.createView(new Game());
	}

	protected abstract View createView(Game game);

	protected void play() {
		this.view.interact();
	}

}
