package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

class ErrorView {

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(error.toString());
        }
    }

}
