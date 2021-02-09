package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;

class StartView {

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.startController);
    }

}
