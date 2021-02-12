package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends Controller implements AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.proposalController = new ProposalController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
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
