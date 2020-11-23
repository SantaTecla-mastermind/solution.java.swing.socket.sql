package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class StartView {

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        Console.getInstance().writeln(Message.TITLE.getMessage());
        new SecretCombinationView(this.startController).writeln();
    }

}
