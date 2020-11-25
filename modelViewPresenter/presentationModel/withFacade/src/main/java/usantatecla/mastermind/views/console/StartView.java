package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class StartView extends Console {

    private Logic logic;

    private SecretCombinationView secretCombinationView;

    StartView(Logic logic) {
        this.logic = logic;
        this.secretCombinationView = new SecretCombinationView(this.logic);
    }

    void interact() {
        Console.getInstance().writeln(MessageView.TITLE.getMessage());
        this.secretCombinationView.writeln();
    }

}
