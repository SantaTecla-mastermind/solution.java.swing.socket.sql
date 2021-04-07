package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.SessionImplementation;

public class RedoController extends Controller {

    public RedoController(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    public void redo() {
        this.sessionImplementation.redo();
    }

    public boolean redoable() {
        return this.sessionImplementation.redoable();
    }

}
