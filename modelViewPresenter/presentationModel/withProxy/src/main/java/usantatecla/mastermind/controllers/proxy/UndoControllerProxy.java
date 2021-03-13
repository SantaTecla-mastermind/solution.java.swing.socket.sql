package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class UndoControllerProxy extends UndoController {

    private TCPIP tcpip;

    public UndoControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

}
