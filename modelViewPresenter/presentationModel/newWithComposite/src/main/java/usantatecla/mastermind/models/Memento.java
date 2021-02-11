package usantatecla.mastermind.models;

// TODO Preguntar si calcular results a partir de SecretCombination y si los ProposedCombination los pasamos como string
class Memento {

    private ProposedCombination[] proposedCombinations;
    private Result[] results;

    public Memento(ProposedCombination[] proposedCombinations, Result[] results) {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        for (int i = 0; i < Board.MAX_ATTEMPTS; i++) {
            if (proposedCombinations[i] != null && results[i] != null) {
                this.proposedCombinations[i] = proposedCombinations[i].clone();
                this.results[i] = results[i].clone();
            }
        }
    }

    // TODO Devolviamos array directamente!! Problemas con referencias. Solucionado con clone
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
