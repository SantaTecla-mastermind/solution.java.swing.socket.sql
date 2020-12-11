package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

class StartView extends WithLogicView {

    private SecretCombinationView secretCombinationView;

    StartView(Logic logic) {
        super(logic);
        this.secretCombinationView = new SecretCombinationView(this.logic);
    }

    void interact() {
        Console.getInstance().writeln(Message.TITLE.getMessage());
        this.secretCombinationView.writeln();
    }

}
