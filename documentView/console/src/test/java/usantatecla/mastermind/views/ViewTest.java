package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ViewTest {
    @Mock
    Game game;

    @Mock
    Console console;

    @InjectMocks
    View view;

    @Test
    void testGivenViewWhenInteractAndIsFinishedAndIsNotNewGameThenCorrectNumberOfConsoleCallsHappens() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.getAttempts()).thenReturn(0);
            when(this.game.isWinner()).thenReturn(true);
            when(this.console.readString()).thenReturn("rgby");
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            this.view.interact();
            verify(this.console, times(3)).writeln(anyString());
            verify(this.console, times(3)).writeln();
            verify(this.console, times(10)).write(anyString());
        }
    }
}
