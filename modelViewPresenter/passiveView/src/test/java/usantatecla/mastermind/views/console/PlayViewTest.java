package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    private PlayView playView;

    @BeforeEach
    public void beforeEach() {
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenWriteWinnerThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.writeWinner();
            verify(this.console).writeln("You've won!!! ;-)");
        }
    }

    @Test
    public void testGivenPlayViewWhenWriteLooserThenIsLooser() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.writeLooser();
            verify(this.console).writeln("You've lost!!! :-(");
        }
    }

}
