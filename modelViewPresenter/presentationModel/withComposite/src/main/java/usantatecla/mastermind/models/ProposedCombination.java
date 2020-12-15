package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public class ProposedCombination extends Combination {

	public ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (Color value : this.colors) {
			if (value == color) {
				return true;
			}
		}
		return false;
	}

	public static ProposedCombination parse(String colorsString) {
		List<Color> colors = new ArrayList<>();
		for(Character character : colorsString.toCharArray()) {
			colors.add(Color.parse(character));
		}
		return new ProposedCombination(colors);
	}

	@Override
	public String toString() {
		String colorString = "";
		for (Color color : this.colors) {
			colorString += color.toString();
		}
		return colorString;
	}
}
