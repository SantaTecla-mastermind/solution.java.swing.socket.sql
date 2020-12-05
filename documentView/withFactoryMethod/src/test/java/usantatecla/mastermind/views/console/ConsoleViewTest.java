package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.Console;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleViewTest {

    @Mock
    Game game;

    @Mock
    Console console;

    @Mock
    ProposedCombination proposedCombination;

    @Mock
    Result result;

    @InjectMocks
    ConsoleView consoleView;

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('y');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsWinnerGameWhenInteractThenReturnsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readString()).thenReturn("rgby");
            when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
            when(this.game.getAttempts()).thenReturn(1);
            when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
            when(this.game.getResult(anyInt())).thenReturn(this.result);
            when(this.result.getBlacks()).thenReturn(2);
            when(this.result.getWhites()).thenReturn(2);
            when(this.game.isWinner()).thenReturn(true);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.propose(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readString()).thenReturn("rgby");
            when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
            when(this.game.getAttempts()).thenReturn(1);
            when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
            when(this.game.getResult(anyInt())).thenReturn(this.result);
            when(this.result.getBlacks()).thenReturn(2);
            when(this.result.getWhites()).thenReturn(2);
            when(this.game.isWinner()).thenReturn(false);
            when(this.game.isLooser()).thenReturn(false);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.propose(), is(false));
        }
    }
}