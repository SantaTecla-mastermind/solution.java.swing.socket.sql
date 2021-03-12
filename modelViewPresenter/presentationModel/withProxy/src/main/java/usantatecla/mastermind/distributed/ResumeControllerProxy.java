package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class ResumeControllerProxy extends AcceptorController {

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void reset() {
        if (this.tcpip == null) {
            this.session.reset();
        } else {
            this.tcpip.send(FrameType.RESET.name());
        }
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
