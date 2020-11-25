package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

class ErrorView extends usantatecla.mastermind.views.ErrorView {

    ErrorView() {
    }

    ErrorView(Error error) {
        super(error);
    }

    void writeln() {
        if (!this.error.isNull()) {
            Console.getInstance().writeln(new ErrorView().MESSAGES[this.error.ordinal()]);
        }
    }

    @Override
    protected String colorInitials() {
        return new ColorView().allInitials();
    }
}
