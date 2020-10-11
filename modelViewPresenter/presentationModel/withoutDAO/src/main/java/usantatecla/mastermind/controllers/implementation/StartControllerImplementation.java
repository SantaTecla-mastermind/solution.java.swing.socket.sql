package usantatecla.mastermind.controllers.implementation;

import java.util.List;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;

public class StartControllerImplementation extends StartController {

	StartControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		((SessionImplementation) this.session).load(name);
	}

	@Override
	public String[] getGamesNames() {
		return ((SessionImplementation) this.session).getGamesNames();
	}

	@Override
	public int getAttempts() {
		return ((SessionImplementation) this.session).getAttempts();
	}

	@Override
	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	@Override
	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLooser();
	}

	@Override
	public List<Color> getColors(int position) {
		return ((SessionImplementation) this.session).getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return ((SessionImplementation) this.session).getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return ((SessionImplementation) this.session).getWhites(position);
	}

}
