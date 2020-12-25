package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

class Memento {

    private SecretCombination secretCombination;
    private List<String> proposedCombinationsColors;

    public Memento(Game game) {
        this.secretCombination = game.getSecretCombination();
        this.proposedCombinationsColors = new ArrayList<>();
        for (int i = 0; i < game.getAttempts(); i++) {
            this.proposedCombinationsColors.add(game.getProposedCombination(i).toString());
        }
    }

    List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        List<ProposedCombination> proposedCombinations = getProposedCombinations();
        for (ProposedCombination proposedCombination : proposedCombinations) {
            results.add(this.secretCombination.getResult(proposedCombination));
        }
        return results;
    }

    List<ProposedCombination> getProposedCombinations() {
        List<ProposedCombination> proposedCombinations = new ArrayList<>();
        for (String proposedCombinationColor : this.proposedCombinationsColors) {
            proposedCombinations.add(ProposedCombination.parse(proposedCombinationColor));
        }
        return proposedCombinations;
    }

    int getAttempts() {
        return this.proposedCombinationsColors.size();
    }

}
