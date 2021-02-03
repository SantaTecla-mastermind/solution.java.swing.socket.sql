package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Board board, ViewFactory viewFactory) {
        super(board,viewFactory);
    }

    public boolean control(){
        boolean isResumed = new ResumeView().read();
        if (isResumed) {
            this.board.reset();
        }
        return isResumed;
    }

}
