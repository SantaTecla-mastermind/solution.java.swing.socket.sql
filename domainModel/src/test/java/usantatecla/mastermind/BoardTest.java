package usantatecla.mastermind;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

public class BoardTest {

    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
    }

    @Test
    void testIsFinished() {
        ProposedCombination proposedCombination = mock(ProposedCombination.class);
        board.add(proposedCombination);
        assertFalse(board.isFinished());
    }

    @Test
    void testIsWinner() {
        ProposedCombination proposedCombination = mock(ProposedCombination.class);
        board.add(proposedCombination);
        assertFalse(board.isWinner());
    }

}
