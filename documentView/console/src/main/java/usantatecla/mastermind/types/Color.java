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
	
}
