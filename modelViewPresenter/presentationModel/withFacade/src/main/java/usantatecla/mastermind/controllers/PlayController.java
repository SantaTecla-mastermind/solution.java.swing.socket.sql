package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Board board) {
        super(board);
    }

    public Error getError(List<Color> colors) {
        return this.board.getError(colors);
    }

    public void add(List<Color> colors) {
        this.board.add(colors);
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

}
