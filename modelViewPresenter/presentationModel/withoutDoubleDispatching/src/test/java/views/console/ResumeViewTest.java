package views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.console.ResumeView;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    @Mock
    Console console;

    @Mock
    ResumeController resumeController;

    @InjectMocks
    ResumeView resumeView;

    @Test
    void testGivenNewGameMessage() {
        when(this.console.readChar(anyString())).thenReturn('n');
        try(MockedStatic<Console> console = mockStatic(Console.class)){
            console.when(Console::getInstance).thenReturn(this.console);
            this.resumeView.interact(this.resumeController);
            verify(this.console).readChar("Do you want to continue? (y/n): ");
        }
    }
}
