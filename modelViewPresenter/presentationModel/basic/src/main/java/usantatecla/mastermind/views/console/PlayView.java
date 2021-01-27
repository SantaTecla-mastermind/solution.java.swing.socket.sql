package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

public class PlayView {

    private PlayController playController;
    private ProposedCombinationView proposedCombinationView;
    private BoardView boardView;

    PlayView(PlayController playController) {
        this.playController = playController;
        this.proposedCombinationView = new ProposedCombinationView();
        this.boardView = new BoardView(playController, this.proposedCombinationView);
    }

    public void interact() {
        do {
            this.playController.add(new ProposedCombinationView().read().getColors());
            this.boardView.write();
        } while (!this.playController.isFinished());
        if(this.playController.isWinner()){
            Message.WINNER.writeln();
        } else {
            Message.LOOSER.writeln();
        }
    }
}
