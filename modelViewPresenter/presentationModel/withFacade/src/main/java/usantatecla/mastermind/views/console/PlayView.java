package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;

class PlayView extends WithLogicView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            this.logic.add(new ProposedCombinationView().read(this.logic));
            new BoardView().write(this.logic);
        } while (!this.logic.isFinished());
        Message message = Message.LOOSER;
        if (this.logic.isWinner()){
            message = Message.WINNER;
        }
        new MessageView().writeln(message);
    }
    
}
