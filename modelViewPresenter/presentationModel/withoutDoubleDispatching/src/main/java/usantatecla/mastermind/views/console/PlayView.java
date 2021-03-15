package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

class PlayView {

    void interact(PlayController playController) {
        do {
            playController.add(new ProposedCombinationView().read(playController));
            new BoardView().write(playController);
        } while (!playController.isFinished());
        Message message = Message.LOOSER;
        if (playController.isWinner()){
            message = Message.WINNER;
        }
        new MessageView().writeln(message);
        playController.nextState();
    }

}
