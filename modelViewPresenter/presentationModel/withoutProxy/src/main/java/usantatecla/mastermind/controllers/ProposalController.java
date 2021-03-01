package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

class ProposalController extends Controller {

	ProposalController(Session session) {
		super(session);
	}

	Error getError(List<Color> colors) {
		return this.session.getError(colors);
	}

	void add(List<Color> colors) {
		this.session.add(colors);
	}

	boolean isFinished() {
		return this.session.isFinished();
	}

	boolean isWinner() {
		return this.session.isWinner();
	}

}
