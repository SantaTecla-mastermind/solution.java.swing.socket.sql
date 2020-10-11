package usantatecla.mastermind.controllers;

import usantatecla.mastermind.views.ErrorView;

import java.util.List;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ProposedCombinationView;

class ProposalController extends InGameController {

	ProposalController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView().read();
			error = this.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
	}
	
	private Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i + 1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}
			}
		}
		if (error == null) {
			this.session.addProposedCombination(colors);
			if (this.session.isWinner()	|| this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;
	}

}
