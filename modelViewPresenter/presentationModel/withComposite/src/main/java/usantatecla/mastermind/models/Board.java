package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

class Board {

    static final int MAX_ATTEMPTS = 10;
    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;
    private int attempts;

    Board() {
        this.reset();
    }

    void reset() {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        this.secretCombination = new SecretCombination();
        this.attempts = 0;
    }

    void add(List<Color> colors) {
        this.proposedCombinations[this.attempts] = new ProposedCombination(colors);
        this.results[this.attempts] = this.getResult(this.proposedCombinations[this.attempts]);
        this.attempts++;
    }

    Memento createMemento() {
        return new Memento(this.proposedCombinations);
    }

    void setMemento(Memento memento) {
        this.attempts = memento.getAttempts();
        this.proposedCombinations = memento.getProposedCombinations();
        this.results = memento.getResults(this.secretCombination);
    }

    Result getResult(ProposedCombination proposedCombination) {
        return this.secretCombination.getResult(proposedCombination);
    }

    int getBlacks(int position) {
        return this.getResult(position).getBlacks();
    }

    int getWhites(int position) {
        return this.getResult(position).getWhites();
    }

    private Result getResult(int position) {
        assert position < this.getAttempts() && position >= 0;

        return this.results[position];
    }

    List<Color> getProposedCombinationColors(int position) {
        assert position < this.getAttempts() && position >= 0;

        return this.proposedCombinations[position].getColors();
    }

    Error getError(List<Color> colors) {
        return new ProposedCombination(colors).getError();
    }

    int getAttempts() {
        return this.attempts;
    }

    boolean isWinner() {
        if (this.attempts == 0) {
            return false;
        }
        return this.results[this.attempts - 1].isWinner();
    }

    boolean isFinished() {
        return this.isWinner() || this.isLooser();
    }

    private boolean isLooser() {
        return this.attempts == Board.MAX_ATTEMPTS;
    }

}
