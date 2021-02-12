package usantatecla.mastermind.types;

public enum Error {

    DUPLICATED,
    WRONG_CHARACTERS,
    WRONG_LENGTH,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
