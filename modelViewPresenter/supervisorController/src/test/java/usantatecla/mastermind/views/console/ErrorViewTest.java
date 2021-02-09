package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    private Console console;

    private ErrorView errorView;

    @BeforeEach
    public void beforeEach() {
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenCorrectErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.WRONG_CHARACTERS);
            verify(this.console).writeln("Wrong colors, they must be: rgybmc");
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NULL);
            verify(this.console, never()).writeln(anyString());
        }
    }

}
