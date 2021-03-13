package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.AcceptorControllerImplementation;

public class StateValueDispatcher extends Dispatcher {

    public StateValueDispatcher(AcceptorControllerImplementation acceptorControllerImplementation) {
        super(acceptorControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorControllerImplementation.getStateValue().name());
    }

}
