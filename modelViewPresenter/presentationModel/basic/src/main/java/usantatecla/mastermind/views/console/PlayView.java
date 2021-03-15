package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            this.playController.add(new ProposedCombinationView().read(this.playController));
            new BoardView().write(this.playController);
        } while (!this.playController.isFinished());
        Message message = Message.LOOSER;
        if (this.playController.isWinner()){
            message = Message.WINNER;
        }
        new MessageView().writeln(message);
    }
    
}
