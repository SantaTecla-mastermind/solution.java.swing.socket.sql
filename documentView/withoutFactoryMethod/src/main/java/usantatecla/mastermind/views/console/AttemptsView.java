package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class AttemptsView {

    private int attempts;

    AttemptsView(int attempts) {
        this.attempts = attempts;
    }

    void writeln() {
        Console.getInstance().writeln(Message.ATTEMPTS.getMessage().replace("#attempts", "" + this.attempts));
    }
}
