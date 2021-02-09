package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;

public abstract class Controller {

    protected Board board;
    protected ViewFactory viewFactory;

    Controller(Board board, ViewFactory viewFactory) {
        this.board = board;
        this.viewFactory = viewFactory;
    }

}
