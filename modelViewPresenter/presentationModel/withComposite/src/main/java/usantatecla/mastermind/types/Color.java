package usantatecla.mastermind.types;

public enum Color {
	RED,
	BLUE,
	YELLOW,
	GREEN,
	ORANGE,
	PURPLE,
	NULL;

	public static int length() {
		return Color.values().length;
	}

	public boolean isNull() {
		return this == Color.NULL;
	}

	public static Color parse(char character) {
		switch (character) {
			case 'r':
				return Color.RED;
			case 'g':
				return Color.GREEN;
			case 'b':
				return Color.BLUE;
			case 'y':
				return Color.YELLOW;
			case 'o':
				return Color.ORANGE;
			case 'p':
				return Color.PURPLE;
			default:
				return Color.NULL;
		}
	}


	@Override
	public String toString() {
		return this.name().substring(0, 1).toLowerCase();
	}
}
