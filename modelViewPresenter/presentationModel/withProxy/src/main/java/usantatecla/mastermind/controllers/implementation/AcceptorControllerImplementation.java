package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

public abstract class AcceptorControllerImplementation extends Controller implements AcceptorController {

    AcceptorControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void nextState() {
        this.session.nextState();
    }

    @Override
    public StateValue getStateValue() {
        return this.session.getValueState();
    }

    @Override
    public int getAttempts() {
        return this.session.getAttempts();
    }

    @Override
    public List<Color> getProposedCombinationColors(int position) {
        return this.session.getProposedCombinationColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

}
