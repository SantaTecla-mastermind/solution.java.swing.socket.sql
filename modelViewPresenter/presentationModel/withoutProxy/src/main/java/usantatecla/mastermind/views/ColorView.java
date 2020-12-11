package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;
import usantatecla.utils.WithConsoleView;

class ColorView extends Console {

	public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	protected Color color;

	protected ColorView() {
	}

	protected ColorView(Color color) {
		this.color = color;
	}

	public static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return Color.NULL;
	}

	public String allInitials() {
		String result = "";
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			result += resultInitials(i);
		}
		return result;
	}

	protected String resultInitials(int i) {
		return ColorCode.values()[i].getColor() + ColorView.INITIALS[i] + ColorCode.RESET_COLOR.getColor();
	}

	public void write() {
		if (!color.isNull()) {
			Console.getInstance()
					.write(ColorCode.getColorByIndex(this.color.ordinal())
							+ ColorView.INITIALS[this.color.ordinal()]
							+ ColorCode.RESET_COLOR.getColor());
		}
	}

}

