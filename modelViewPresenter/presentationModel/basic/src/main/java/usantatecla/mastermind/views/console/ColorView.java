package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.Console;

class ColorView extends usantatecla.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
