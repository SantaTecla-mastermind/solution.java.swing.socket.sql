package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    private static String INITIALS = "rgby";

    @Mock
    private Console console;

    @Spy
    private Board board;

    private Logic logic;
    private PlayView playView;

    @BeforeEach
    public void beforeEach(){
        this.logic = new Logic(this.board);
        this.playView = new PlayView(this.logic);
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn(PlayViewTest.INITIALS);
            doReturn(true).when(this.board).isWinner();
            this.playView.interact();
            verify(this.board).add(Color.get(PlayViewTest.INITIALS));
            verify(this.console).writeln("You've won!!! ;-)");
        }
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsLooser() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn(PlayViewTest.INITIALS);
            doReturn(true).when(this.board).isFinished();
            doReturn(false).when(this.board).isWinner();
            this.playView.interact();
            verify(this.board).add(Color.get(PlayViewTest.INITIALS));
            verify(this.console).writeln("You've lost!!! :-(");
        }
    }

}
