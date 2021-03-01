package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class FinishedDispatcher extends Dispatcher {

    public FinishedDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController)this.acceptorController).isFinished();
    }
}
