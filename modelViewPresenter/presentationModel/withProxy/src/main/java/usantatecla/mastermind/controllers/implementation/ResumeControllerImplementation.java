package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.models.Session;

public class ResumeControllerImplementation extends AcceptorControllerImplementation implements ResumeController {

    public ResumeControllerImplementation(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
