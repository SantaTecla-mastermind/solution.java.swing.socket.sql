package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.console.StartView;

public class StartController extends Controller {

    public StartController(Board board) {
        super(board);
    }

    public void control(){
        new StartView().write();
        this.writeBoard();
    }

}
