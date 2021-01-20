package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.ColorCode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecretCombinationTest {

    private SecretCombination secretCombination;

    @Mock
    ProposedCombination proposedCombination;

    @BeforeEach
    void beforeEach() {
        this.secretCombination = new SecretCombination();
    }

    @Test
    void testGivenSecretCombinationAndWinnerProposedCombinationWhenGetResultThenIsWinner() {
        when(this.proposedCombination.contains(any(Color.class), anyInt())).thenReturn(true);
        when(this.proposedCombination.contains(any(Color.class))).thenReturn(true);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result.isWinner(),is(true));
    }

    @Test
    void testGivenSecretCombinationAndProposedCombinationWhenGetResultThen0blacksAnd0Whites() {
        when(this.proposedCombination.contains(any(Color.class), anyInt())).thenReturn(false);
        when(this.proposedCombination.contains(any(Color.class))).thenReturn(false);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result ,is(new Result(0,0)));
    }

    @Test
    void testGivenSecretCombinationAndProposedCombinationWhenGetResultThen2blacksAnd2Whites() {
        when(this.proposedCombination.contains(any(Color.class), anyInt())).thenReturn(true, true, false);
        when(this.proposedCombination.contains(any(Color.class))).thenReturn(true);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result ,is(new Result(2,2)));
    }

}
