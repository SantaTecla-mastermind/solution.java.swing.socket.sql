package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.Session;

public class UndoControllerImplementation extends UndoController {

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
