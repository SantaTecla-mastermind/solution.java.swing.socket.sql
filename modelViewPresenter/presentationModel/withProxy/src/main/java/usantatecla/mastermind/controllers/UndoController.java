package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class UndoController extends Controller {

    public UndoController(Session session) {
        super(session);
    }

    public abstract void undo();

    public abstract boolean undoable();

}
