package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class Logic {

    private Board board;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Board board) {
        this.board = board;
        this.startController = new StartController(this.board);
        this.playController = new PlayController(this.board);
        this.resumeController = new ResumeController(this.board);
    }

    public void reset() {
        this.resumeController.reset();
    }

    public Error getError(List<Color> colors) {
        return this.playController.getError(colors);
    }

    public void add(List<Color> colors) {
        this.playController.add(colors);
    }

    public boolean isWinner() {
        return this.playController.isWinner();
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public int getAttempts() {
        return this.startController.getAttempts();
    }

    public List<Color> getProposedCombinationColors(int position) {
        return this.startController.getProposedCombinationColors(position);
    }

    public int getBlacks(int position) {
        return this.startController.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.startController.getWhites(position);
    }

}
