package usantatecla.mastermind.models.DAO;

import usantatecla.mastermind.models.ProposedCombination;

class ProposedCombinationDAO extends CombinationDAO {

	ProposedCombinationDAO(ProposedCombination proposedCombination) {
		super(proposedCombination);
	}

	ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
