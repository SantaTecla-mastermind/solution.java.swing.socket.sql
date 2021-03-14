package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.AcceptorController;

public class NextStateDispatcher extends Dispatcher {

    public NextStateDispatcher(AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        this.acceptorController.nextState();
    }
}
