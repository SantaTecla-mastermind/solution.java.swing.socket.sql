package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.GameView;

public abstract class InGameController extends Controller {

	private GameView gameView;

	InGameController(Session session) {
		super(session);
		this.gameView = new GameView(this.session.getGame());
	}

	@Override
	public void control() {
		this.inGameControl();
		this.gameView.writeGame();
		if (this.session.isWinner()) {
			this.gameView.writeWinner();
		} else if (this.session.isLooser()) {
			this.gameView.writeLooser();
		}
	}

	protected abstract void inGameControl();

}
