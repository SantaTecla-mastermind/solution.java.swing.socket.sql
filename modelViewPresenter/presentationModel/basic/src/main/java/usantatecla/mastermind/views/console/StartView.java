package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;

public class StartView  {

    private StartController startController;
    private ProposedCombinationView proposedCombinationView;
    private BoardView boardView;

    StartView(StartController startController) {
        this.startController = startController;
        this.proposedCombinationView = new ProposedCombinationView();
        this.boardView = new BoardView(startController, this.proposedCombinationView);
    }

    void interact() {
        Message.TITLE.writeln();
        this.boardView.write();
    }

}
