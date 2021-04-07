package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.models.SessionImplementation;

public class ResumeControllerImplementation extends AcceptorControllerImplementation implements ResumeController {

    public ResumeControllerImplementation(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    public void reset() {
        this.sessionImplementation.reset();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
