package usantatecla.mastermind;

import usantatecla.utils.Console;

enum Color {
	RED('r'), 
	BLUE('b'), 
	YELLOW('y'), 
	GREEN('g'), 
	ORANGE('o'), 
	PURPLE('p'),
	NULL_COLOR;

	private char initial;

	private Color() {
	}

	private Color(char initial) {
		this.initial = initial;
	}

	static String getInitials() {
		String result = "";
		for(int i=0; i<Color.length(); i++) {
			result += Color.get(i).initial;
		}
		return result;
	}

	static Color getInstance(char character) {
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
		new Console().write(this.initial);
	}

	boolean isNull(){
		return this == Color.NULL_COLOR;
	}
	
}
