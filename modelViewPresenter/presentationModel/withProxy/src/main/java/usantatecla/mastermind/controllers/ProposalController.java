package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class ProposalController extends Controller {

    public ProposalController(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    public Error getError(List<Color> colors) {
        return this.sessionImplementation.getError(colors);
    }

    public void add(List<Color> colors) {
        this.sessionImplementation.add(colors);
    }

    public boolean isFinished() {
        return this.sessionImplementation.isFinished();
    }

    public boolean isWinner() {
        return this.sessionImplementation.isWinner();
    }

}
