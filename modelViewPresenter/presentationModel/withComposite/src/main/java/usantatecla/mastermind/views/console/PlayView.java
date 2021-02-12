package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while(!playController.isFinished());

        if (playController.isWinner()){
            new MessageView().writeln(Message.WINNER);
        } else {
            new MessageView().writeln(Message.LOOSER);
        }
        playController.nextState();
    }

}
