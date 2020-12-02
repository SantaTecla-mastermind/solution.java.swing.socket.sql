package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

public class ColorView extends usantatecla.mastermind.views.ColorView {

	public ColorView() {
	}

	public ColorView(Color color) {
		super(color);
	}

	@Override
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