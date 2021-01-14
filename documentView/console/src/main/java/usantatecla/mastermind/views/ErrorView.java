package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

class ErrorView {

    private Error error;

    ErrorView(Error error) {
        this.error = error;
    }

    void writeln() {
        if (!this.error.isNull()) {
            Console.getInstance().writeln(error.toString());
        }
    }

}
