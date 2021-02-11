package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
