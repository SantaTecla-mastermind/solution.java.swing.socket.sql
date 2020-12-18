package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

class Game {

	private static final int MAX_LONG = 10;
	private SecretCombination secretCombination;
	private List<ProposedCombination> proposedCombinations;
	private List<Result> results;
	private int attempts;

	Game() {
		this.clear();
	}

	void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<>();
		this.results = new ArrayList<>();
		this.attempts = 0;
	}

	void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}
	
	Memento createMemento() {
		List<String> proposedCombinationsColors = new ArrayList<>();
		List<Integer> blacks = new ArrayList<>();
		List<Integer> whites = new ArrayList<>();

		for (int i = 0; i < this.attempts; i++) {
			proposedCombinationsColors.add(this.proposedCombinations.get(i).toString());
			blacks.add(this.results.get(i).getBlacks());
			whites.add(this.results.get(i).getWhites());
		}
		// TODO
		return new Memento(this.attempts, proposedCombinationsColors, blacks, whites);
	}

	void set(Memento memento) {
		this.attempts = memento.getAttempts();
		this.proposedCombinations = memento.getProposedCombinations();
		this.results = memento.getResults();
	}

	boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	boolean isWinner() {
		if (this.attempts == 0) {
			return false;
		}
		return this.results.get(this.attempts-1).isWinner();
	}

	int getAttempts() {
		return this.attempts;
	}

	List<Color> getColors(int position) {
		assert position < this.proposedCombinations.size();
		return this.proposedCombinations.get(position).colors;
	}

	int getBlacks(int position) {
		assert position < this.results.size();
		return this.results.get(position).getBlacks();
	}

	int getWhites(int position) {
		assert position < this.results.size();
		return this.results.get(position).getWhites();
	}

	int getWidth() {
		return Combination.getWidth();
	}

}
