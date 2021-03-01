package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

class Memento {

    private String[] proposedCombinationsStrings;

    Memento(ProposedCombination[] proposedCombinations) {
        this.proposedCombinationsStrings = new String[proposedCombinations.length];
        for(int i = 0; i < proposedCombinations.length; i++) {
            if (proposedCombinations[i] != null)
                this.proposedCombinationsStrings[i] = proposedCombinations[i].toString();
        }
    }

    ProposedCombination[] getProposedCombinations() {
        ProposedCombination[] proposedCombinations = new ProposedCombination[this.proposedCombinationsStrings.length];
        for(int i = 0; i < proposedCombinations.length; i++) {
            if (this.proposedCombinationsStrings[i] != null)
                proposedCombinations[i] = new ProposedCombination(Color.get(this.proposedCombinationsStrings[i]));
        }
        return proposedCombinations;
    }

    Result[] getResults(SecretCombination secretCombination) {
        Result[] results = new Result[this.proposedCombinationsStrings.length];
        ProposedCombination[] proposedCombinations = this.getProposedCombinations();
        for(int i = 0; i < proposedCombinations.length; i++) {
            if (proposedCombinations[i] != null)
                results[i] = secretCombination.getResult(proposedCombinations[i]);
        }
        return results;
    }

    int getAttempts() {
        for (int i = 0; i < Board.MAX_ATTEMPTS; i++) {
            if (this.proposedCombinationsStrings[i] == null) return i;
        }
        return Board.MAX_ATTEMPTS;
    }

}
