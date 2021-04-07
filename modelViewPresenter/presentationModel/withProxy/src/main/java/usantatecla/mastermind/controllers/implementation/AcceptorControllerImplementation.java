package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

public abstract class AcceptorControllerImplementation extends Controller implements AcceptorController {

    AcceptorControllerImplementation(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    @Override
    public void nextState() {
        this.sessionImplementation.nextState();
    }

    public StateValue getStateValue() {
        return this.sessionImplementation.getValueState();
    }

    @Override
    public int getAttempts() {
        return this.sessionImplementation.getAttempts();
    }

    @Override
    public List<Color> getProposedCombinationColors(int position) {
        return this.sessionImplementation.getProposedCombinationColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.sessionImplementation.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.sessionImplementation.getWhites(position);
    }

}
