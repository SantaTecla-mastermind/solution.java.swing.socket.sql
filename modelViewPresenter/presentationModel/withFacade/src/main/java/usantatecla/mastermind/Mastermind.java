package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public abstract class Mastermind {

    private final View view;

    protected Mastermind() {
        this.view = this.createView(new Logic());
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        this.view.interact();
    }

}
