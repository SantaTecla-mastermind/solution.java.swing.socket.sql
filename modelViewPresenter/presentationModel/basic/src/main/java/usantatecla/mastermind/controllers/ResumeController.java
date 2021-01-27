package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;

public class ResumeController extends Controller {

    public ResumeController(Board board) {
        super(board);
    }

    public void reset() {
        this.board.reset();
    }

}
