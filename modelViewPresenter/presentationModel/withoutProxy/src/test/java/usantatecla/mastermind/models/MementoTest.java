package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class MementoTest {

    private static final String INITIALS = "rgby";

    private Board board;
    private Memento memento;
    private ProposedCombination[] proposedCombinations;

    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder()
                .proposedCombinations(3, MementoTest.INITIALS)
                .build();
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        for (int i = 0; i < this.board.getAttempts(); i++) {
            this.proposedCombinations[i] = new ProposedCombination(this.board.getProposedCombinationColors(i));
        }
        this.memento = new Memento(this.proposedCombinations);
    }

    @Test
    public void testGivenMementoWhenGetProposedCombinationsThenReturn() {
        assertThat(this.memento.getProposedCombinations(), is(this.proposedCombinations));
    }

    @Test
    public void testGivenMementoWhenGetResultsThenReturn() {
        SecretCombination secretCombination = spy(new SecretCombination());
        doReturn(new Result(2, 2)).when(secretCombination).getResult(any());
        Result[] results = new Result[Board.MAX_ATTEMPTS];
        for (int i = 0; i < this.board.getAttempts(); i++) {
            results[i] = new Result(2, 2);
        }
        assertThat(this.memento.getResults(secretCombination), is(results));
    }

    @Test
    public void testGivenMementoWhenGetAttemptsThenReturn() {
        assertThat(this.memento.getAttempts(), is(this.board.getAttempts()));
    }

}
