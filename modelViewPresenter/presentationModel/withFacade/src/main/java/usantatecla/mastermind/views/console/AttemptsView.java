package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

class AttemptsView extends Console {

    private Logic logic;

    AttemptsView(Logic logic) {
        this.logic = logic;
    }

    public void writeln() {
        Console.getInstance()
                .writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.logic.getAttempts()));
    }

}
