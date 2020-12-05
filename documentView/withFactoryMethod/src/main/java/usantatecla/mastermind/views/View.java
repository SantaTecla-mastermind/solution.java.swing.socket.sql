package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;

public abstract class View extends WithGameView {

    public View(Game game) {
        super(game);
    }

    public void interact() {
        do {
            this.start();
            boolean finished;
            do {
                finished = this.propose();
            } while (!finished);
        } while (this.isNewGame());
    }

    protected abstract void start();

    protected abstract boolean propose();

    protected abstract boolean isNewGame();

}
