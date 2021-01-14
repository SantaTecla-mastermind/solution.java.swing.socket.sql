package usantatecla.mastermind.models;

//TODO Game únicamente actúa de fachada, ¿está bien así? ¿Tests?
public class Game {

    private Board board;

    public Game() {
        this.reset();
    }

    public void reset() {
        this.board = new Board();
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.board.getProposedCombination(position);
    }

    public Result getResult(int position) {
        return this.board.getResult(position);
    }

    public int getAttempts() {
        return this.board.getAttempts();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.board.add(proposedCombination);
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

}
