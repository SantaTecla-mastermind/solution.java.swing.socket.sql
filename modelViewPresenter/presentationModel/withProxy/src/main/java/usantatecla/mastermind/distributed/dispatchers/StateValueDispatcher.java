package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.AcceptorController;

public class StateValueDispatcher extends Dispatcher {

    public StateValueDispatcher(AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getStateValue().name());
    }

}
