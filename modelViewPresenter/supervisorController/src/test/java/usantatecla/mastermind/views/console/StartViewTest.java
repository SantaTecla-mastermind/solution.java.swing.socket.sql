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
public class StartViewTest {

    @Mock
    private Console console;

    private StartView startView;


    @BeforeEach
    public void beforeEach() {
        this.startView = new StartView();
    }

    @Test
    public void testGivenStartViewWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.startView.write();
            String string = "----- MASTERMIND -----";
            verify(this.console).writeln(string);
        }
    }
}
