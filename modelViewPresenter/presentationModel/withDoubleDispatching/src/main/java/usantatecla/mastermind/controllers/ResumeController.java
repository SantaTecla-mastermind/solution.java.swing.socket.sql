package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.State;

public class ResumeController extends Controller {

    public ResumeController(Board board, State state) {
        super(board, state);
    }

    public void reset() {
        this.board.reset();
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
