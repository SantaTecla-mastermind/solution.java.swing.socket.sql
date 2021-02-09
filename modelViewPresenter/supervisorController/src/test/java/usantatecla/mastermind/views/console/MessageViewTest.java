package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageViewTest {

    @Mock
    private Console console;

    private MessageView messageView;

    @BeforeEach
    public void beforeEach() {
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenWriteMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.PROPOSED_COMBINATION);
            verify(this.console, times(1)).writeln(Message.PROPOSED_COMBINATION.toString());
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithAttemptsThenWriteAttemptsMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            int attempts = 5;
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.ATTEMPTS,attempts);
            verify(this.console, times(1)).writeln(Message.ATTEMPTS.toString().replaceAll("#attempts", "" + attempts));
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithBlacksAndWhitesThenWriteResultMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            int blacks = 2;
            int whites = 2;
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.RESULT,blacks,whites);
            verify(this.console, times(1)).writeln(Message.RESULT.toString().replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
        }
    }

}
