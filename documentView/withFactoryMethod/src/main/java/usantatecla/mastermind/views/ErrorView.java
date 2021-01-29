package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.Console;

public class ErrorView {

    public static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + Color.getAllInitials(),
            "Wrong proposed combination length"
        };

    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(usantatecla.mastermind.views.ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
