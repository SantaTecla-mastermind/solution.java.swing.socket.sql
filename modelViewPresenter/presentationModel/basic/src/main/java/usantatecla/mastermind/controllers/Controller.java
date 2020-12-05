package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.WithGameView;

public abstract class Controller extends WithGameView {

    Controller(Game game) {
        super(game);
    }

    public int getWidth() {
        return Combination.getWidth();
    }

}
