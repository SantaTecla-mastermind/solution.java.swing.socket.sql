package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;

public abstract class View extends WithLogicView {

    public View(Logic logic) {
        super(logic);
    }

    public void interact() {
        boolean newGame;
        do {
            this.start();
            boolean finished;
            do {
                finished = this.propose();
            } while (!finished);
            newGame = this.isNewGame();
        } while (newGame);
    }

    protected abstract void start();

    protected abstract boolean propose();

    protected abstract boolean isNewGame();

}
