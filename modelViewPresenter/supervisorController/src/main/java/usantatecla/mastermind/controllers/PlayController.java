package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ViewFactory;

public class PlayController extends Controller {

    public PlayController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        do {
            this.board.add(this.readProposedCombination());
            this.viewFactory.createBoardView(this.board).write();
        } while (!this.board.isFinished());
        if (this.board.isWinner()){
            this.viewFactory.createPlayView().writeWinner();
        } else {
            this.viewFactory.createPlayView().writeLooser();
        }
    }

    private ProposedCombination readProposedCombination() {
        Error error;
        ProposedCombination proposedCombination;
        do {
            proposedCombination = this.viewFactory.createProposedCombinationView().read();
            error = proposedCombination.getError();
            this.viewFactory.createErrorView().writeln(error);
        } while (!error.isNull());
        return proposedCombination;
    }

}
