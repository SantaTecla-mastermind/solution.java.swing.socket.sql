package usantatecla.mastermind.models;

public enum Color {
	RED,
	BLUE,
	YELLOW,
	GREEN,
	ORANGE,
	PURPLE,
	NULL;

	static int length() {
		return Color.values().length;
	}

	public boolean isNull() {
		return this == Color.NULL;
	}
	
}
