package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.AcceptorControllerImplementation;

public class NextStateDispatcher extends Dispatcher {

    public NextStateDispatcher(AcceptorControllerImplementation acceptorControllerImplementation) {
        super(acceptorControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.acceptorControllerImplementation.nextState();
    }
}
