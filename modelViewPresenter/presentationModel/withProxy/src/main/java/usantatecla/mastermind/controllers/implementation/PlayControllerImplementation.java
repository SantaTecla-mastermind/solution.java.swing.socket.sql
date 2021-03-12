package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.*;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayControllerImplementation extends AcceptorControllerImplementation implements PlayController {

    private ProposalControllerImplementation proposalControllerImplementation;
    private UndoControllerImplementation undoControllerImplementation;
    private RedoControllerImplementation redoControllerImplementation;

    public PlayControllerImplementation(Session session) {
        super(session);
        this.proposalControllerImplementation = new ProposalControllerImplementation(this.session);
        this.undoControllerImplementation = new UndoControllerImplementation(this.session);
        this.redoControllerImplementation = new RedoControllerImplementation(this.session);
    }

    public boolean undoable() {
        return this.undoControllerImplementation.undoable();
    }

    public boolean redoable() {
        return this.redoControllerImplementation.redoable();
    }

    public void undo() {
        this.undoControllerImplementation.undo();
    }

    public void redo() {
        this.redoControllerImplementation.redo();
    }

    public Error getError(List<Color> colors) {
        return this.proposalControllerImplementation.getError(colors);
    }

    public void add(List<Color> colors) {
        this.proposalControllerImplementation.add(colors);
    }

    public boolean isFinished() {
        return this.proposalControllerImplementation.isFinished();
    }

    public boolean isWinner() {
        return this.proposalControllerImplementation.isWinner();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
