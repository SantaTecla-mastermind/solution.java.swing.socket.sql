package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;

public abstract class Controller {

    protected Board board;

    Controller(Board board) {
        this.board = board;
    }

}
