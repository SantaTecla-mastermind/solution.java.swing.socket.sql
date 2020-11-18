package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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
        when(this.game.getAttempts()).thenReturn(0);
        when(this.game.isWinner()).thenReturn(true);
        try(MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgby");
            when(this.console.readChar(anyString())).thenReturn('n');
            this.view.interact();

            /* INTERACCIONES CON CONSOLE:
             * STARTVIEW
             * Provoca 1 writeln(String), 1 writeln() y 1 write(String)
             *
             * PROPOSALVIEW
             * Provoca 2 writeln(String), 2 writeln(), 2 write(String)
             *
             * RESUMEVIEW
             * Provoca 1 write(String)
             */

            verify(this.console, times(3)).writeln(anyString());
            verify(this.console, times(3)).writeln();
            verify(this.console, times(4)).write(anyString());
        }
    }
}
