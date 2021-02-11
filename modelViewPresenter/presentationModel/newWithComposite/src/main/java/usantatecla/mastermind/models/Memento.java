package usantatecla.mastermind.models;

// TODO Preguntar si calcular results a partir de SecretCombination y si los ProposedCombination los pasamos como string
class Memento {

    private ProposedCombination[] proposedCombinations;
    private Result[] results;

    // TODO Revisar Memento. Posible problema con referencias (cambiar al de strings)
    public Memento(ProposedCombination[] proposedCombinations, Result[] results) {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        for (int i = 0; i < Board.MAX_ATTEMPTS; i++) {
            this.proposedCombinations[i] = proposedCombinations[i];
            this.results[i] = results[i];
        }
    }

    ProposedCombination[] getProposedCombinations() {
        return this.proposedCombinations;
    }

    Result[] getResults() {
        return this.results;
    }

    int getAttempts() {
        for (int i = 0; i < Board.MAX_ATTEMPTS; i++) {
            if (this.proposedCombinations[i] == null) return i;
        }
        return Board.MAX_ATTEMPTS;
    }

}
