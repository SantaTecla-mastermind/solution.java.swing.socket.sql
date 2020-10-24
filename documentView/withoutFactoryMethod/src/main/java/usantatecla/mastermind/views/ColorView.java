package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Color;
import usantatecla.utils.ColorCode;

public class ColorView {
	
	public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	protected Color color;

	protected ColorView(Color color) {
		this.color = color;
	}

	// TODO Implementar método plantilla. graphics no soporta colores
	static String allInitials() {
		String result = "";
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			result += ColorCode.values()[i].getColor() + ColorView.INITIALS[i] + ColorCode.RESET_COLOR.getColor();
		}
		return result;
	}

	public static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}

}
