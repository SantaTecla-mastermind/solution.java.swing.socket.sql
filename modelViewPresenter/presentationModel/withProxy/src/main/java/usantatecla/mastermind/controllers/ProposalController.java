package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public abstract class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public abstract Error getError(List<Color> colors);

	public abstract void add(List<Color> colors);

	public abstract boolean isFinished();

	public abstract boolean isWinner();

}
