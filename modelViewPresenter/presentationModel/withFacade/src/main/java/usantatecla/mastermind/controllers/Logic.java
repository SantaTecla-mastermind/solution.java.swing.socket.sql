package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;

public class Logic {

    private Board board;
    private StartController startController; //TODO ?
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

    public void add(ProposedCombination proposedCombination) {
        this.playController.add(proposedCombination);
    }

    public boolean isWinner() {
        return this.playController.isWinner();
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public int getAttempts() {
        return this.playController.getAttempts();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.playController.getProposedCombination(position);
    }

    public int getBlacks(int position) {
        return this.playController.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.playController.getWhites(position);
    }

}
