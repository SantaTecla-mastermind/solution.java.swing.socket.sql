package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;

public class StartControllerProxy extends AcceptorControllerProxy implements StartController {

    public StartControllerProxy(TCPIP tcpip) {
        super(tcpip);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
