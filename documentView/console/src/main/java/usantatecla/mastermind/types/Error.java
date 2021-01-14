package usantatecla.mastermind.types;

import usantatecla.mastermind.models.ColorFactory;

public enum Error {

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

    public boolean isNull() {
        return this == Error.NULL;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
