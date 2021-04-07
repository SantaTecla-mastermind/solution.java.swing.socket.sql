package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.SessionImplementation;

public class UndoController extends Controller {

    public UndoController(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
    }

    public void undo() {
        this.sessionImplementation.undo();
    }

    public boolean undoable() {
        return this.sessionImplementation.undoable();
    }

}
