package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

class SecretCombinationView extends WithLogicView {

    SecretCombinationView(Logic logic) {
        super(logic);
    }

    public void writeln() {
        for (int i = 0; i < this.logic.getWidth(); i++) {
            Console.getInstance().write(Message.SECRET.getMessage());
        }
        Console.getInstance().writeln();
    }

}
