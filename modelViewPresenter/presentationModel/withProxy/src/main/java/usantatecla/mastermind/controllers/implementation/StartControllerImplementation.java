package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.SessionImplementation;

public class StartControllerImplementation extends AcceptorControllerImplementation implements StartController {

    public StartControllerImplementation(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
