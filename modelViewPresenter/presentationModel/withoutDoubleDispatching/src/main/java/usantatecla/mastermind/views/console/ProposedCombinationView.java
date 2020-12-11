package usantatecla.mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.Console;
import usantatecla.mastermind.views.Message;

public class ProposedCombinationView {
	
	private ProposalController proposalController;
	
	public ProposedCombinationView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}
	
	public void write(int position) {
		for (Color color : this.proposalController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
