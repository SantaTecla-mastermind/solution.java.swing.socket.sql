package usantatecla.mastermind;

import usantatecla.utils.Console;

public class Board {

    static final int MAX_ATTEMPTS = 10;
    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;
    private int attempts;

    Board() {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        this.reset();
    }

    void reset() {
        this.secretCombination = new SecretCombination();
        this.attempts = 0;
    }

    void add(ProposedCombination proposedCombination) {
        this.proposedCombinations[this.attempts] = proposedCombination;
        this.results[this.attempts] = this.getResult(proposedCombination);
        this.attempts++;
    }

    Result getResult(ProposedCombination proposedCombination) {
        return this.secretCombination.getResult(proposedCombination);
    }

    boolean isFinished() {
        return this.isWinner() || this.isLooser();
    }

    boolean isWinner() {
        return this.results[this.attempts - 1].isWinner();
    }

    private boolean isLooser() {
        return this.attempts == Board.MAX_ATTEMPTS;
    }

    void write() {
        Console.getInstance().writeln();
        Message.ATTEMPTS.writeln(this.attempts);
        this.secretCombination.writeln();
        for (int i = 0; i < this.attempts; i++) {
            this.proposedCombinations[i].write();
            this.results[i].writeln();
        }
    }
    
}
