package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class RedoController extends Controller {

    public RedoController(Session session) {
        super(session);
    }

    public abstract void redo();

    public abstract boolean redoable();

}
