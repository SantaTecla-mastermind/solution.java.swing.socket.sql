package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

public interface AcceptorController {

    void nextState();
    StateValue getStateValue();
    int getAttempts();
    List<Color> getProposedCombinationColors(int position);
    int getBlacks(int position);
    int getWhites(int position);
    void accept(ControllersVisitor controllersVisitor);

}
