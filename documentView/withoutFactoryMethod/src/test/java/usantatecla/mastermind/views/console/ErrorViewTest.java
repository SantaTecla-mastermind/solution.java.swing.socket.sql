package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    Console console;

    ErrorView errorView;

    @Test
    void testGivenCorrectErrorWhenWritelnThenCapturesCorrectArgument() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            this.errorView = new ErrorView(Error.WRONG_LENGTH);
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console).writeln("Wrong proposed combination length");
        }
    }

    @Test
    void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            this.errorView = new ErrorView(Error.NULL);
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console, never()).writeln(anyString());
        }
    }
}