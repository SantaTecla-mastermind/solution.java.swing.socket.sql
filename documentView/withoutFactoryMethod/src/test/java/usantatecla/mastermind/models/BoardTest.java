package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private static final String PROPOSED_COMBINATION = "rgby";

    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenBoardWithSomeProposedCombinationWhenResetThenGetAttemptsIs0() {
        Board board = this.boardBuilder
                .proposedCombinations(3, BoardTest.PROPOSED_COMBINATION)
                .build();
        board.reset();
        assertThat(board.getAttempts(), is(0));
    }

    @Test
    public void testGivenBoardWhenAddThenCorrect() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .build();
        assertThat(board.getProposedCombinationColors(0), is(Color.get(BoardTest.PROPOSED_COMBINATION)));
    }

    @Test
    public void testGivenBoardWhenGetBlacksThenReturn() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(2)
                .whites(2)
                .build();
        assertThat(board.getBlacks(0), is(2));
    }

    @Test
    public void testGivenBoardWhenGetWhitesThenReturn() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(2)
                .whites(2)
                .build();
        assertThat(board.getBlacks(0), is(2));
    }

    @Test
    public void testGivenBoardWhenGetWhitesOrBlacksOrProposedCombinationWithIncorrectNumberThenAssertError() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .build();
        Assertions.assertThrows(AssertionError.class, () -> board.getWhites(board.getAttempts()));
        Assertions.assertThrows(AssertionError.class, () -> board.getBlacks(board.getAttempts()));
        Assertions.assertThrows(AssertionError.class, () -> board.getProposedCombinationColors(board.getAttempts()));
    }

    @Test
    public void testGivenBoardWhenGetAttemptsThenReturn() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .build();
        assertThat(board.getAttempts(), is(1));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH)
                .whites(0)
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenFalse() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH - 1)
                .whites(0)
                .build();
        assertThat(board.isFinished(), is(false));
    }

    @Test
    public void testGivenBoardAndAdd10ProposedCombinationWhenIsFinishedThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(Board.MAX_ATTEMPTS, BoardTest.PROPOSED_COMBINATION)
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH)
                .whites(0)
                .build();
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenFalse() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH - 1)
                .whites(0)
                .build();
        assertThat(board.isWinner(), is(false));
    }

}
