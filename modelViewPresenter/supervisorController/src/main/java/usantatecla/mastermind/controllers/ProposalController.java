package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.ProposedCombinationView;

class ProposalController extends InGameController {

	ProposalController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		ProposedCombination proposedCombination = new ProposedCombination();
		new ProposedCombinationView(proposedCombination).read();
		this.session.addProposedCombination(proposedCombination);
		if (this.session.isWinner() || this.session.isLooser()) {
			this.session.next();
		}
	}

}
