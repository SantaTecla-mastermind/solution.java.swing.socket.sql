package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class StartController extends Controller {

    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
