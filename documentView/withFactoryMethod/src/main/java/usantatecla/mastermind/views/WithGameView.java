package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

public abstract class WithGameView {

    protected Game game;

    public WithGameView(Game game) {
        this.game = game;
    }
}
