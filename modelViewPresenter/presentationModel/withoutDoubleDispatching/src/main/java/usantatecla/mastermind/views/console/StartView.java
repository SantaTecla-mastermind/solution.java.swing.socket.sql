package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;

class StartView  {

    void interact(StartController startController) {
        Message.TITLE.writeln();
        new BoardView().write(startController);
        startController.nextState();
    }

}
