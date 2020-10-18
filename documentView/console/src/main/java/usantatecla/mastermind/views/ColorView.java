package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.WithConsoleView;

class ColorView extends WithConsoleView{
	
	private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};
	private Color color;

	ColorView(Color color) {
		this.color = color;
	}

	static String allInitials() {
		String result = "";
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			result += ColorCode.values()[i].color + ColorView.INITIALS[i] + ColorCode.RESET_COLOR;
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
		this.console
				.write(ColorCode.values()[this.color.ordinal()].color
				+ ColorView.INITIALS[this.color.ordinal()]
				+ ColorCode.RESET_COLOR.color);
	}

}
