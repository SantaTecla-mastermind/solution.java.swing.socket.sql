package usantatecla.mastermind;

import usantatecla.utils.Console;

enum Error {
    DUPLICATED("Repeated colors"),
    WRONG_CHARACTERS("Wrong colors, they must be: " + Color.getInitials()),
    WRONG_LENGTH("Wrong proposed combination length"),
    NULL_ERROR;

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
        return this == Error.NULL_ERROR;
    }

}
