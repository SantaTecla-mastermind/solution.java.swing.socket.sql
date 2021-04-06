package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    private static String INITIALS = "rgby";

    @Mock
    private Console console;

    private Session session;
    private PlayController playController;
    private PlayView playView;

    @BeforeEach
    public void beforeEach() {
        this.session = spy(new Session(null));
        this.playController = new PlayController(this.session, null);
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("")).thenReturn(1);
            when(this.console.readString(anyString())).thenReturn(PlayViewTest.INITIALS);
            doReturn(true).when(this.session).isFinished();
            doReturn(true).when(this.session).isWinner();
            this.playView.interact(this.playController);
            verify(this.session).add(Color.get(PlayViewTest.INITIALS));
            verify(this.console).writeln("You've won!!! ;-)");
        }
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsLooser() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("")).thenReturn(1);
            when(this.console.readString(anyString())).thenReturn(PlayViewTest.INITIALS);
            doReturn(true).when(this.session).isFinished();
            doReturn(false).when(this.session).isWinner();
            this.playView.interact(this.playController);
            verify(this.session).add(Color.get(PlayViewTest.INITIALS));
            verify(this.console).writeln("You've lost!!! :-(");
        }
    }

}
