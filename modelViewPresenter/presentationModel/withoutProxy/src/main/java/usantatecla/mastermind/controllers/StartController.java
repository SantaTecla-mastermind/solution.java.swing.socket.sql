package usantatecla.mastermind.controllers;

import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;

public class StartController extends AcceptorController {

    public StartController(Session session, TCPIP tcpip) {
        super(session, tcpip);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
