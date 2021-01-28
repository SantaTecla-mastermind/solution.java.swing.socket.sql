package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.Console;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

    ErrorView() {
        super();
    }

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(usantatecla.mastermind.views.ErrorView.MESSAGES[error.ordinal()]);
        }
    }
    
}
