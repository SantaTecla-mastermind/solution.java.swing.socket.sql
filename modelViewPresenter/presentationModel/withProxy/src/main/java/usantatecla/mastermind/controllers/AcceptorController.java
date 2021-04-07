package usantatecla.mastermind.controllers;

import usantatecla.mastermind.types.Color;

import java.util.List;

public interface AcceptorController {

    void nextState();
    int getAttempts();
    List<Color> getProposedCombinationColors(int position);
    int getBlacks(int position);
    int getWhites(int position);
    void accept(ControllersVisitor controllersVisitor);

}
