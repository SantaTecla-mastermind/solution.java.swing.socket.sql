package usantatecla.mastermind.controllers;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class ResumeController extends AcceptorController {

    public ResumeController(Session session, TCPIP tcpip) {
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
