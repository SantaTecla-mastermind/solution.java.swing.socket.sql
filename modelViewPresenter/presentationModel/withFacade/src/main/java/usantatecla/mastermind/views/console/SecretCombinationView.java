package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class SecretCombinationView extends Console {

    private Logic logic;

    SecretCombinationView(Logic logic) {
        this.logic = logic;
    }

    public void writeln() {
        for (int i = 0; i < this.logic.getWidth(); i++) {
            Console.getInstance().write(MessageView.SECRET.getMessage());
        }
        Console.getInstance().writeln();
    }

}
