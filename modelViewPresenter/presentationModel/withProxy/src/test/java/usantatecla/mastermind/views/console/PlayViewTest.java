package usantatecla.mastermind.views.console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.Console;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    private static String INITIALS = "rgby";

    @Mock
    private Console console;

    @Spy
    private SessionImplementation session;

    private PlayController playController;
    private PlayView playView;

    @BeforeEach
    public void beforeEach(){
        this.playController = new PlayControllerImplementation(this.session);
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
