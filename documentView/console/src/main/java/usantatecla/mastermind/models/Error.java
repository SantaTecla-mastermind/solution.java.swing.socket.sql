package usantatecla.mastermind.models;

public enum Error {
	DUPLICATED,
	WRONG_CHARACTERS,
	WRONG_LENGTH,
	NULL;

	public boolean isNull() {
		return this == Error.NULL;
	}
}
