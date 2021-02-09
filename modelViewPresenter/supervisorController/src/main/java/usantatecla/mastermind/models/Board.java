package usantatecla.mastermind.models;

public class Board {

    static final int MAX_ATTEMPTS = 10;
    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;
    private int attempts;

    public Board() {
        this.reset();
    }

    public void reset() {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        this.secretCombination = new SecretCombination();
        this.attempts = 0;
    }

    public void add(ProposedCombination proposedCombination) {
        this.proposedCombinations[this.attempts] = proposedCombination;
        this.results[this.attempts] = this.getResult(this.proposedCombinations[this.attempts]);
        this.attempts++;
    }

    Result getResult(ProposedCombination proposedCombination) {
        return this.secretCombination.getResult(proposedCombination);
    }

    public int getBlacks(int position) {
        return this.getResult(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.getResult(position).getWhites();
    }

    public Result getResult(int position) {
        assert position < this.getAttempts() && position >= 0;

        return this.results[position];
    }

    public ProposedCombination getProposedCombination(int position) {
        assert position < this.getAttempts() && position >= 0;

        return this.proposedCombinations[position];
    }

    public int getAttempts() {
        return this.attempts;
    }

    public boolean isFinished() {
        return this.isWinner() || this.isLooser();
    }

    public boolean isWinner() {
        return this.results[this.attempts - 1].isWinner();
    }

    private boolean isLooser() {
        return this.attempts == Board.MAX_ATTEMPTS;
    }
}
