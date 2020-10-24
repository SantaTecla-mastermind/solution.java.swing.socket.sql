package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

class ColorView extends usantatecla.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		Console.getInstance()
				.write(ColorCode.getColorByIndex(this.color.ordinal())
						+ usantatecla.mastermind.views.ColorView.INITIALS[this.color.ordinal()]
						+ ColorCode.RESET_COLOR.getColor());
	}

}
