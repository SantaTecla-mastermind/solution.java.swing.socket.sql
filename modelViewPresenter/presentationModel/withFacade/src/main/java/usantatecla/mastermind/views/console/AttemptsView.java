package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

class AttemptsView extends WithLogicView {

    AttemptsView(Logic logic) {
        super(logic);
    }

    public void writeln() {
        Console.getInstance()
                .writeln(Message.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.logic.getAttempts()));
    }

}
