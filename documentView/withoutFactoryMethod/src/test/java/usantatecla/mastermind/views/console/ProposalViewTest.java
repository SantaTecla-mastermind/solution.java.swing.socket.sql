package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.utils.Console;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProposalViewTest {

    @Mock
    Game game;

    @Mock
    Console console;

    @Mock
    ProposedCombination proposedCombination;

    @Mock
    Result result;

    @InjectMocks
    ProposalView proposalView;

    @BeforeEach
    void before() {
        when(this.console.readString()).thenReturn("rgby");
        when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        when(this.game.getAttempts()).thenReturn(1);
        when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
        when(this.game.getResult(anyInt())).thenReturn(this.result);
        when(this.result.getBlacks()).thenReturn(2);
        when(this.result.getWhites()).thenReturn(2);
    }

    @Test
    void testGiven1AttemptAndIsWinnerGameWhenInteractThenReturnsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.isWinner()).thenReturn(true);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.proposalView.interact(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.isWinner()).thenReturn(false);
            when(this.game.isLooser()).thenReturn(false);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.proposalView.interact(), is(false));
        }
    }
}
