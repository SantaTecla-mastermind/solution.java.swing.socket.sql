package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.utils.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    Logic logic;

    @Mock
    Console console;

    @InjectMocks
    StartView startView;

    @Test
    void testGivenStartViewWhenInteractThenCorrectMessagesAreCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.startView = new StartView(this.logic);
            when(this.logic.getWidth()).thenReturn(4);
            startView.interact();

            verify(this.console).writeln("----- MASTERMIND -----");
            verify(this.console).writeln();
            verify(this.console, times(4)).write("*");
        }
    }
}
