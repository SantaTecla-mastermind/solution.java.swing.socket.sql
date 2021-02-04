package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;

public class ResumeController extends Controller {

    public ResumeController(Board board, ViewFactory viewFactory) {
        super(board,viewFactory);
    }

    public boolean control(){
        boolean isResumed = this.viewFactory.createResumeView().read();
        if (isResumed) {
            this.board.reset();
        }
        return isResumed;
    }

}
