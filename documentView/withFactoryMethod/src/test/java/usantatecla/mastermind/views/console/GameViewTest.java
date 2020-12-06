package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameViewTest {

    @Mock
    Game game;

    @Mock
    ProposedCombination proposedCombination;

    @Mock
    Result result;

    @Mock
    Console console;

    @InjectMocks
    GameView gameView;

    @Test
    void testGivenWinGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(true);
        assertThat(this.gameView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenLooseGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(true);
        assertThat(this.gameView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenNotLooseNorWinGameWhenIsWinnerOrLooserThenReturnsFalse() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(false);
        assertThat(this.gameView.isWinnerOrLooser(), is(false));
    }

    @Test
    void testGivenEmptyGameStateWhenWriteThenOnlySecretCombinationIsWritten() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.getAttempts()).thenReturn(0);
            console.when(Console::getInstance).thenReturn(this.console);
            this.gameView.write();
            verify(this.console, times(2)).writeln();
            verify(this.console, times(4)).write("*");
        }
    }

    @Test
    void testGiven2AttemptsGameStateWhenWriteThenCorrectArgumentsAreCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.getAttempts()).thenReturn(2);
            when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
            when(this.game.getResult(anyInt())).thenReturn(this.result);
            when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.ORANGE, Color.YELLOW));
            when(this.result.getBlacks()).thenReturn(0);
            when(this.result.getWhites()).thenReturn(0);
            ArgumentCaptor<String> secretCombination = ArgumentCaptor.forClass(String.class);
            ArgumentCaptor<String> proposedCombination = ArgumentCaptor.forClass(String.class);
            console.when(Console::getInstance).thenReturn(this.console);
            this.gameView.write();
            verify(this.console, times(3)).writeln(secretCombination.capture());
            verify(this.console, times(12)).write(proposedCombination.capture());
            assertThat(secretCombination.getAllValues().get(0), is("2 attempt(s): "));
            assertThat(proposedCombination.getAllValues().toString(),
                    is("[*, *, *, *, " + "\u001B[31m" + "r" + "\u001B[0m, " +
                            "\u001B[32m" + "g" + "\u001B[0m, " +
                            "\u001B[37m" + "o" + "\u001B[0m, " +
                            "\u001B[33m" + "y" + "\u001B[0m, " +
                            "\u001B[31m" + "r" + "\u001B[0m, " +
                            "\u001B[32m" + "g" + "\u001B[0m, " +
                            "\u001B[37m" + "o" + "\u001B[0m, " +
                            "\u001B[33m" + "y" + "\u001B[0m]"));
        }
    }
}