package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

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

    ProposedCombination getProposedCombination(int position) {
        return this.proposedCombinations.get(position);
    }

    SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    Memento createMemento() {
        return new Memento(this);
    }

    void setMemento(Memento memento) {
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
        return this.results.get(this.attempts - 1).isWinner();
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
