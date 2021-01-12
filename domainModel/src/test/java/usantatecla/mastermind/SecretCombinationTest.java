package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecretCombinationTest {

    private SecretCombination secretCombination;

    @Mock
    Console console;

    @BeforeEach
    void before() {
        this.secretCombination = new SecretCombination();
    }

    @Test
    //Mock de proposedCombination o hacerlo con colores reales??
    void testGivenNewSecretCombinationAndValidProposedCombinationWhenGetResultThenReturnTrue() {
        ProposedCombination proposedCombination = mock(ProposedCombination.class);
        when(proposedCombination.contains(any(ColorCode.class), anyInt())).thenReturn(true);
        when(proposedCombination.contains(any(ColorCode.class))).thenReturn(true);
        Result result = secretCombination.getResult(proposedCombination);
        assertThat(result.isWinner(),is(true));
    }

    @Test
    void testWriteln(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Message.SECRET_COMBINATION.write();
            verify(this.console, times(1)).write(Message.SECRET_COMBINATION.toString());
        }
    }

}
