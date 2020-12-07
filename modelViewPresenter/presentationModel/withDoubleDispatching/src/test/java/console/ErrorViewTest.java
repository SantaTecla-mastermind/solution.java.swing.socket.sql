package console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.console.ErrorView;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    Console console;

    ErrorView errorView;

    @Test
    void testGivenCorrectErrorWhenWritelnThenCapturesCorrectArgument() {
        this.errorView = new ErrorView(Error.WRONG_LENGTH);
        ArgumentCaptor<String> errorMessage = ArgumentCaptor.forClass(String.class);
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console).writeln(errorMessage.capture());
            assertThat(errorMessage.getValue(), is("Wrong proposed combination length"));
        }
    }

    @Test
    void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        this.errorView = new ErrorView(Error.NULL);
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console, never()).writeln(anyString());
        }
    }
}
