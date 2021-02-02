package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.console.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Board board) {
        super(board);
    }

    public boolean control(){
        boolean isResumed = new ResumeView().read();
        if (isResumed) {
            this.board.reset();
        }
        return isResumed;
    }

}
