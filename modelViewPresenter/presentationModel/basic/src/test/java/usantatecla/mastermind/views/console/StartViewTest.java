package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    StartController startController;

    @Mock
    Console console;

    @InjectMocks
    StartView startView;

    @Test
    void testGivenStartViewWhenInteractThenCorrectMessagesAreCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.startController.getWidth()).thenReturn(4);
            console.when(Console::getInstance).thenReturn(this.console);
            startView.interact();
            verify(this.console).writeln("----- MASTERMIND -----");
            verify(this.console).writeln();
            verify(this.console, times(4)).write("*");
        }
    }
}
