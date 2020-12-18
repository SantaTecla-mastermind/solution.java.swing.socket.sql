package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

class Memento {

	private int attempts;
	private List<String> proposedCombinationsColors;

	// TODO blacks y whites se puede recalcular a partir de la SecretCombination
	private List<Integer> blacks;
	private List<Integer> whites;

	public Memento(int attempts, List<String> proposedCombinationsColors, List<Integer> blacks, List<Integer> whites) {
		this.attempts = attempts;
		this.proposedCombinationsColors = proposedCombinationsColors;
		this.blacks = blacks;
		this.whites = whites;
	}

	List<ProposedCombination> getProposedCombinations(){
		List<ProposedCombination> proposedCombinations = new ArrayList<>();
		for(String proposedCombinationColor : this.proposedCombinationsColors) {
			proposedCombinations.add(ProposedCombination.parse(proposedCombinationColor));
		}
		return proposedCombinations;
	}
	
	List<Result> getResults(){
		List<Result> results = new ArrayList<>();
		for(int i = 0; i < this.blacks.size(); i++) {
			results.add(new Result(this.blacks.get(i), this.whites.get(i)));
		}
		return results;
	}

	int getAttempts(){
		return this.attempts;
	}

}
