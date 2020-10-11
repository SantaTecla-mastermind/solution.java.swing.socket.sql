package usantatecla.mastermind.models.Files;

import usantatecla.mastermind.models.ProposedCombination;

public class ProposedCombinationFileDAO extends CombinationFileDAO{
	
	ProposedCombinationFileDAO(ProposedCombination proposedCombination){
		super(proposedCombination);
	}

	public ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
