package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;

public class StartController extends Controller {

    public StartController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        this.viewFactory.createStartView().write();
        this.viewFactory.createBoardView(this.board).write();
    }

}
