package usantatecla.mastermind.views;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ViewTest {
    /*
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

     */
}
