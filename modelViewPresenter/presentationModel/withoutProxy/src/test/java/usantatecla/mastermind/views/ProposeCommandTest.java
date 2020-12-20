package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;
import usantatecla.utils.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposeCommandTest {

    @Mock
    Console console;

    PlayController playController = new PlayController(new Session(null), null);

    @InjectMocks
    ProposeCommand proposeCommand = new ProposeCommand(this.playController);

    @Test
    public void testGivenExecuteProposeCommandWhenCorrectColorsThenGameViewIsDisplayed() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString("Propose a combination: ")).thenReturn("ybop");

            this.proposeCommand.execute();
            verify(this.console, times(2)).writeln("");
            verify(this.console).writeln("1 attempt(s): ");
            verify(this.console, times(4)).write("*");
            verify(this.console).write("\u001B[33my\u001B[0m");
            verify(this.console).write("\u001B[34mb\u001B[0m");
            verify(this.console).write("\u001B[37mo\u001B[0m");
            verify(this.console).write("\u001B[35mp\u001B[0m");
            verify(this.console).writeln(" --> " + this.playController.getBlacks(0) +
                                        " blacks and " + this.playController.getWhites(0) + " whites");

        }
    }

    @Test
    public void testGivenExecuteProposeCommandWhenIncorrectColorsThenCorrectErrorViewsAreDisplayed() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString("Propose a combination: ")).thenReturn("rygop", "rgho",
                    "rggo", "ybop");

            this.proposeCommand.execute();
            verify(this.console, times(2)).writeln("");
            verify(this.console).writeln("Wrong proposed combination length");
            verify(this.console).writeln("Wrong colors, they must be: " +
                                               "\u001B[31mr\u001B[0m" +
                                               "\u001B[34mb\u001B[0m" +
                                               "\u001B[33my\u001B[0m" +
                                               "\u001B[32mg\u001B[0m" +
                                               "\u001B[37mo\u001B[0m" +
                                               "\u001B[35mp\u001B[0m");
            verify(this.console).writeln("Repeated colors");
            verify(this.console).writeln("1 attempt(s): ");
            verify(this.console, times(4)).write("*");
            verify(this.console).write("\u001B[33my\u001B[0m");
            verify(this.console).write("\u001B[34mb\u001B[0m");
            verify(this.console).write("\u001B[37mo\u001B[0m");
            verify(this.console).write("\u001B[35mp\u001B[0m");
            verify(this.console).writeln(" --> " + this.playController.getBlacks(0) +
                    " blacks and " + this.playController.getWhites(0) + " whites");
        }
    }
    
}