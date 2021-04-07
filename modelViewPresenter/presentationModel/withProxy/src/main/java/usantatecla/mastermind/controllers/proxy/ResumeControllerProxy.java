package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;

public class ResumeControllerProxy extends AcceptorControllerProxy implements ResumeController {

    public ResumeControllerProxy(TCPIP tcpip) {
        super(tcpip);
    }

    public void reset() {
        this.tcpip.send(FrameType.RESET.name());
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
