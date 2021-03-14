package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class ProposalControllerImplementation extends Controller implements ProposalController {

    public ProposalControllerImplementation(Session session) {
        super(session);
    }

    public Error getError(List<Color> colors) {
        return this.session.getError(colors);
    }

    public void add(List<Color> colors) {
        this.session.add(colors);
    }

    public boolean isFinished() {
        return this.session.isFinished();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

}
