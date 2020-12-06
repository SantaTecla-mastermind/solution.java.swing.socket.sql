package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

class ErrorView {

    private static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + ColorView.allInitials(),
            "Wrong proposed combination length"};

    private Error error;

    ErrorView(Error error) {
        this.error = error;
    }

    void writeln() {
        if (!this.error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
        }
    }

}
