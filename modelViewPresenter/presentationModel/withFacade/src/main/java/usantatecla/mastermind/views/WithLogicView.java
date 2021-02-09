package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.Logic;

public abstract class WithLogicView {

    protected Logic logic;

    public WithLogicView(Logic logic) {
        this.logic = logic;
    }
    
}
