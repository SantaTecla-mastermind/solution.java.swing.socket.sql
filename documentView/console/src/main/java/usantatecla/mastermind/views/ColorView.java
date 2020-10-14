package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Color;
import usantatecla.utils.WithConsoleView;

class ColorView extends WithConsoleView{
	
	private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};
	private static final String[] COLORS = {"\u001B[31m", "\u001B[34m", "\u001B[33m", "\u001B[32m", "\u001B[37m", "\u001B[35m"};
	private static final String RESET_COLOR = "\u001B[0m";

	private Color color;

	ColorView(Color color) {
		this.color = color;
	}

	static String allInitials() {
		String result = "";
		char[] initials = ColorView.INITIALS;
		for (int i = 0; i < initials.length; i++) {
			result += ColorView.COLORS[i] + ColorView.INITIALS[i] + ColorView.RESET_COLOR;
		}
		return result;
	}

	static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}
	
	void write() {
		this.console.write(ColorView.COLORS[this.color.ordinal()] + ColorView.INITIALS[this.color.ordinal()] + RESET_COLOR);
	}

}
