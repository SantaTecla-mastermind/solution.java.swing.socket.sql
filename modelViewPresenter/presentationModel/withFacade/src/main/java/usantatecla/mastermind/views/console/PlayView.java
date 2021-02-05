package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;

public class PlayView {

    private Logic logic;

    PlayView(Logic logic) {
        this.logic = logic;
    }

    public void interact() {
        do {
            this.logic.add(new ProposedCombinationView().read(this.logic));
            new BoardView().write(this.logic);
        } while (!this.logic.isFinished());
        if(this.logic.isWinner()){
            new MessageView().writeln(Message.WINNER);
        } else {
            new MessageView().writeln(Message.LOOSER);
        }
    }
}
