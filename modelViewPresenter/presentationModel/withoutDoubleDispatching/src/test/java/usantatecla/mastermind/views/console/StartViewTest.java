package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.State;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private Console console;

    private StartController startController;
    private StartView startView;

    @BeforeEach
    public void beforeEach(){
        this.startController = new StartController(new Board(), new State());
        this.startView = new StartView();
    }

    @Test
    public void testGivenStartViewWhenInteractThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.startView.interact(this.startController);
            String[] strings = {
                    "----- MASTERMIND -----",
                    "0 attempt(s): ",
                    "****"
            };
            for (String string : strings) {
                verify(this.console).writeln(string);
            }
        }
    }


}
