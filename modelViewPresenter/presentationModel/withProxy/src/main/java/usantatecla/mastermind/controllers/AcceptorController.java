package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

public abstract class AcceptorController extends Controller {

    public AcceptorController(Session session) {
        super(session);
    }

    public abstract void nextState();

    public abstract StateValue getStateValue();

    public abstract int getAttempts();

    public abstract List<Color> getProposedCombinationColors(int position);

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract void accept(ControllersVisitor controllersVisitor);

}
