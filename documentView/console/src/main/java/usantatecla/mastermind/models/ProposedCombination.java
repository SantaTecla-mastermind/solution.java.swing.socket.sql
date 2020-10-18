package usantatecla.mastermind.models;

import java.util.List;

public class ProposedCombination extends Combination {

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

	public List<Color> getColors() {
		return this.colors;
	}

}
