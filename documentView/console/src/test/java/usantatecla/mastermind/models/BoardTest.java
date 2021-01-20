package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private static final String PROPOSED_COMBINATION = "rgby";
    private Board board;

    private void setBoard(int times) {
        this.board = new BoardBuilder().proposedCombinations(times, BoardTest.PROPOSED_COMBINATION)
                .build();
    }

    private void setBoard(int times, Result result) {
        this.board = new BoardBuilder().proposedCombinations(times, BoardTest.PROPOSED_COMBINATION)
                .result(result).build();
    }

    @Test
    public void testGivenBoardWithSomeProposedCombinationWhenResetThenGetAttemptsIs0() {
        this.setBoard(3);
        this.board.reset();
        assertThat(this.board.getAttempts(), is(0));
    }

    @Test
    public void testGivenBoardWhenAddThenCorrect() {
        this.setBoard(1);
        assertThat(this.board.getProposedCombination(0).getColors(),
                is(Color.get(BoardTest.PROPOSED_COMBINATION)));
    }

    @Test
    public void testGivenBoardWhenGetBlacksThenReturn() {
        this.setBoard(1, new Result(Result.WIDTH - 1,0));
        assertThat(this.board.getBlacks(0), is(Result.WIDTH - 1));
    }

    @Test
    public void testGivenBoardWhenGetWhitesThenReturn() {
        this.setBoard(1, new Result(0,Result.WIDTH - 1));
        assertThat(this.board.getWhites(0), is(Result.WIDTH - 1));
    }

    @Test
    public void testGivenBoardWhenGetWhitesOrBlacksOrProposedCombinationWithIncorrectNumberThenAssertError() {
        this.setBoard(1);
        Assertions.assertThrows(AssertionError.class, () -> this.board.getWhites(this.board.getAttempts()));
        Assertions.assertThrows(AssertionError.class, () -> this.board.getBlacks(this.board.getAttempts()));
        Assertions.assertThrows(AssertionError.class, () -> this.board.getProposedCombination(this.board.getAttempts()));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenTrue(){
        this.setBoard(1, new Result(Result.WIDTH,0));

        assertThat(this.board.isWinner(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenFalse(){
        this.setBoard(1, new Result(Result.WIDTH - 1,0));

        assertThat(this.board.isWinner(),is(false));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenTrue(){
        this.setBoard(1, new Result(Result.WIDTH,0));

        assertThat(this.board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenFalse(){
        this.setBoard(1, new Result(0,Result.WIDTH));

        assertThat(this.board.isFinished(),is(false));
    }

    @Test
    public void testGivenBoardAndAdd10ProposedCombinationWhenIsFinishedThenTrue(){
        this.setBoard(10);

        assertThat(board.isFinished(),is(true));
    }

}
