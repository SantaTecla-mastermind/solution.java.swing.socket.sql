package usantatecla.mastermind.views.console;

import usantatecla.utils.views.Console;
import usantatecla.mastermind.types.Error;

public class ErrorView extends usantatecla.mastermind.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
