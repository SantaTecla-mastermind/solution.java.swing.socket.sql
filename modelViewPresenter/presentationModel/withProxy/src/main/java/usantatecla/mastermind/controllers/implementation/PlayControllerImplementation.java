package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.*;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayControllerImplementation extends AcceptorControllerImplementation implements PlayController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayControllerImplementation(SessionImplementation sessionImplementation) {
        super(sessionImplementation);
        this.proposalController = new ProposalController(this.sessionImplementation);
        this.undoController = new UndoController(this.sessionImplementation);
        this.redoController = new RedoController(this.sessionImplementation);
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    public Error getError(List<Color> colors) {
        return this.proposalController.getError(colors);
    }

    public void add(List<Color> colors) {
        this.proposalController.add(colors);
    }

    public boolean isFinished() {
        return this.proposalController.isFinished();
    }

    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
