package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

public class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    public void interact() {
        do {
            this.playController.add(new ProposedCombinationView().read(this.playController));
            new BoardView().write(this.playController);
        } while (!this.playController.isFinished());
        if(this.playController.isWinner()){
            Message.WINNER.writeln();
        } else {
            Message.LOOSER.writeln();
        }
    }
}
