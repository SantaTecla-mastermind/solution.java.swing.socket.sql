package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Session session) {
        super(session);
    }

    public boolean undoable() {
        return this.session.undoable();
    }

    public boolean redoable() {
        return this.session.redoable();
    }

    public void undo() {
        this.session.undo();
    }

    public void redo() {
        this.session.redo();
    }

    public Error getError(List<Color> colors) {
        return this.session.getError(colors);
    }

    public void add(List<Color> colors) {
        this.session.add(colors);
    }

    public boolean isFinished() {
        return this.session.isFinished();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
