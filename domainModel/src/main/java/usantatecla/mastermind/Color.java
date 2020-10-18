package usantatecla.mastermind;

import usantatecla.utils.Console;

enum Color {
	RED("\u001B[31mr"),
	BLUE("\u001B[34mb"),
	YELLOW("\u001B[33my"),
	GREEN("\u001B[32mg"),
	ORANGE("\u001B[37mo"),
	PURPLE("\u001B[35mp"),
	NULL_COLOR;

	private String initial;
	private static final String RESET_COLOR = "\u001B[0m";

	private Color() {
	}

	private Color(String initial) {
		this.initial = initial;
	}

	static String getInitials() {
		String result = "";
		for(int i=0; i<Color.length(); i++) {
			result += Color.get(i).initial;
		}
		return result;
	}

	static Color getInstance(String character) {
		for(int i=0; i<Color.length(); i++) {
			if (Color.get(i).initial == character) {
				return Color.get(i);
			}
		}
		return Color.NULL_COLOR;
	}

	static int length() {
		return Color.values().length-1;
	}

	static Color get(int index){
		return Color.values()[index];
	}

	void write() {
		assert this != Color.NULL_COLOR;
		new Console().write(this.initial+Color.RESET_COLOR);
	}

	boolean isNull(){
		return this == Color.NULL_COLOR;
	}
	
}
