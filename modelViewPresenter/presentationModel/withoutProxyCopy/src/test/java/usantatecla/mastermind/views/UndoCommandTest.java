package usantatecla.mastermind.views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionBuilder;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UndoCommandTest {
    @Mock
    Console console;

    Session session;
    PlayController playController;
    UndoCommand undoCommand;

    private void setTestVariables(String... proposedCombinationStrings) {
        this.session = new SessionBuilder().proposedCombinations(proposedCombinationStrings).build();
        this.playController = new PlayController(this.session, null);
        this.undoCommand = new UndoCommand(this.playController);
    }

    @Test
    public void testGivenNotUndoableSessionWhenExecuteThenAssertErrorIsThrown() {
        this.setTestVariables();
        assertThat(this.undoCommand.isActive(), is(false));
        Assertions.assertThrows(AssertionError.class, () -> this.undoCommand.execute());
    }

    @Test
    public void testGivenUndoableSessionWhenIsActiveThenIsTrue() {
        this.setTestVariables("rgby");
        assertThat(this.undoCommand.isActive(), is(true));
    }

    @Test
    public void testGivenUndoableSessionWhenExecuteThenGameViewPrintsCorrectGameState() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.setTestVariables("ybop", "rgby");
            this.undoCommand.execute();
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
}
