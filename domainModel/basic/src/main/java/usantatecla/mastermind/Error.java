package usantatecla.mastermind;

import usantatecla.utils.Console;

enum Error {

    DUPLICATED("Repeated colorFactories"),
    WRONG_CHARACTERS("Wrong colors, they must be: " + ColorFactory.getInstance().getInitials()),
    WRONG_LENGTH("Wrong proposed combination length"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            Console.getInstance().writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }

}
