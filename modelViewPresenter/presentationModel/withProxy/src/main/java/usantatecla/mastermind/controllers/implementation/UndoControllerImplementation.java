package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.Session;

public class UndoControllerImplementation extends Controller implements UndoController {

    public UndoControllerImplementation(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean undoable() {
        return this.session.undoable();
    }

}
