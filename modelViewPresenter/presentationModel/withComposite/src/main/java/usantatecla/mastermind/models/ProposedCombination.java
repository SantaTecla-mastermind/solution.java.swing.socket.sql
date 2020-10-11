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
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}
	
	ProposedCombination copy() {
		List<Color> colors = new ArrayList<Color>();
		for(Color color: this.colors) {
			colors.add(color);
		}
		return new ProposedCombination(colors);
	}
	public static Builder builder() {
        return new Builder();
	}
	
	public static class Builder {
		private ProposedCombination proposedCombination;
		private Builder () {
			this.proposedCombination = new ProposedCombination(new ArrayList<Color>());
		}
		public Builder colors (String colors){
			List<Color> colorsOut = new ArrayList<Color>();
			for(int i = 0; i< colors.length(); i++){
				char caracter = colors.charAt(i);
				switch(caracter){
					case 'r':
						colorsOut.add(Color.RED);
						break;
					case 'b':
						colorsOut.add(Color.BLUE);
						break;
					case 'y':
						colorsOut.add(Color.YELLOW);
						break;
					case 'g':
						colorsOut.add(Color.GREEN);
						break;
					case 'o':
						colorsOut.add(Color.ORANGE);
						break;
					default:
						colorsOut.add(Color.PURPLE);
						break;
				}
			
			}
			this.proposedCombination = new ProposedCombination(colorsOut);
			return this;

		}
		public List<Color> build() {
			return this.proposedCombination.colors;
		}

}


}
