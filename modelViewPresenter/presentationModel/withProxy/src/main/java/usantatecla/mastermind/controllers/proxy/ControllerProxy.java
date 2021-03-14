package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public abstract class ControllerProxy extends Controller {

    protected TCPIP tcpip;

    protected ControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

}
