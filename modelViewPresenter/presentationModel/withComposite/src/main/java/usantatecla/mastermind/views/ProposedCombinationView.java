package usantatecla.mastermind.views;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.Console;

class ProposedCombinationView {
	
	private PlayController playController;
	
	ProposedCombinationView(PlayController playController) {
		this.playController = playController;
	}
	
	void write(int position) {
		for (Color color : this.playController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
