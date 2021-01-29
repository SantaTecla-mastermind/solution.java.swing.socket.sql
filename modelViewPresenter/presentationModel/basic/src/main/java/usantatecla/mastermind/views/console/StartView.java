package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;

public class StartView  {

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.startController);
    }

}
