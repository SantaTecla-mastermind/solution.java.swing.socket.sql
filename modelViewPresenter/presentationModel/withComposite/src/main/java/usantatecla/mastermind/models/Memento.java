package usantatecla.mastermind.models;

// TODO Hacerlo con strings
class Memento {

    private ProposedCombination[] proposedCombinations;
    private Result[] results;

    Memento(ProposedCombination[] proposedCombinations, Result[] results) {
        this.proposedCombinations = proposedCombinations;
        this.results = results;
    }

    ProposedCombination[] getProposedCombinations() {
        return this.proposedCombinations.clone();
    }

    Result[] getResults() {
        return this.results.clone();
    }

    int getAttempts() {
        for (int i = 0; i < Board.MAX_ATTEMPTS; i++) {
            if (this.proposedCombinations[i] == null) return i;
        }
        return Board.MAX_ATTEMPTS;
    }

}
