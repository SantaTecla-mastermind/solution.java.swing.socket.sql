package usantatecla.mastermind.views;

import usantatecla.mastermind.models.ColorFactory;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + ColorFactory.getInstance().getInitials(),
            "Wrong proposed combination length"};

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
