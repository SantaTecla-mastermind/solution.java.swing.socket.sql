package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.RedoController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class RedoControllerProxy extends ControllerProxy implements RedoController {

    public RedoControllerProxy(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

}
