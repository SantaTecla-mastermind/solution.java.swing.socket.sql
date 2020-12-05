package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class StartView {

    void interact() {
        Console.getInstance().writeln(Message.TITLE.getMessage());
        new SecretCombinationView().writeln();
    }

}
