package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Session;

public class StartControllerImplementation extends AcceptorControllerImplementation implements StartController {

    public StartControllerImplementation(Session session) {
        super(session);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
