package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecretCombinationTest {

    private SecretCombination secretCombination;

    @BeforeEach
    void before() {
        this.secretCombination = new SecretCombination();
    }

    @Test
    void testGetResult() {
        ProposedCombination proposedCombination = mock(ProposedCombination.class);
        when(proposedCombination.contains(any(Color.class), anyInt())).thenReturn(true);
        when(proposedCombination.contains(any(Color.class))).thenReturn(true);
        Result result = secretCombination.getResult(proposedCombination);
        assertTrue(result.isWinner());
    }

}
