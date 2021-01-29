package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageTest {

    @Mock
    private Console console;

    @Test
    public void testGivenNewMessageWhenWritelnWithoutParamsThenWriteMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Message.PROPOSED_COMBINATION.writeln();
            verify(this.console, times(1)).writeln(Message.PROPOSED_COMBINATION.toString());
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithAttemptsThenWriteAttemptsMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            int attempts = 5;
            console.when(Console::getInstance).thenReturn(this.console);
            Message.ATTEMPTS.writeln(attempts);
            verify(this.console, times(1)).writeln(Message.ATTEMPTS.toString().replaceAll("#attempts", "" + attempts));
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithBlacksAndWhitesThenWriteResultMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            int blacks = 2;
            int whites = 2;
            console.when(Console::getInstance).thenReturn(this.console);
            Message.RESULT.writeln(blacks, whites);
            verify(this.console, times(1)).writeln(Message.RESULT.toString().replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
        }
    }

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.RESUME.toString(), is("Do you want to continue"));
    }
}
