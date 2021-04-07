package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.implementation.AcceptorControllerImplementation;

public class StateValueDispatcher extends Dispatcher {

    public StateValueDispatcher(AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((AcceptorControllerImplementation) this.acceptorController).getStateValue().name());
    }

}
