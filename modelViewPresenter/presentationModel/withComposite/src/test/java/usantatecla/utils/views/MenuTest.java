package usantatecla.utils.views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.Command;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuTest {

    private static final String COMMAND_TITLE_ACTIVE = "Active command";
    private static final String COMMAND_TITLE_NOT_ACTIVE = "Not active command";

    @Mock
    private Console console;

    private Menu menu;

    private Command getActiveCommand() {
        return new Command(MenuTest.COMMAND_TITLE_ACTIVE) {
            @Override
            public void execute() { }

            @Override
            public boolean isActive() {
                return true;
            }
        };
    }

    private Command getNotActiveCommand() {
        return new Command(MenuTest.COMMAND_TITLE_NOT_ACTIVE) {
            @Override
            public void execute() { }

            @Override
            public boolean isActive() {
                return false;
            }
        };
    }

    @BeforeEach
    public void beforeEach() {
        this.menu = new Menu() { };
    }

    @Test
    public void testGivenEmptyMenuWhenExecuteThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> this.menu.execute());
    }

    @Test
    public void testGivenMenuWithNotActiveCommandsThenAssertionError() {
        this.menu.addCommand(this.getNotActiveCommand());
        this.menu.addCommand(this.getNotActiveCommand());
        Assertions.assertThrows(AssertionError.class, () -> this.menu.execute());
    }

    @Test
    public void testGivenMenuWithActiveCommandsWhenExecuteThenPrintAndRead() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("")).thenReturn(1);
            Command command = spy(this.getActiveCommand());
            this.menu.addCommand(command);
            this.menu.addCommand(this.getNotActiveCommand());
            this.menu.execute();
            verify(this.console).writeln();
            verify(this.console).writeln("----- Choose one option -----");
            verify(this.console).writeln("1) " + MenuTest.COMMAND_TITLE_ACTIVE);
            verify(command).execute();
        }
    }

    @Test
    public void testGivenMenuWithActiveCommandsWhenExecuteWithErrorThenPrintAndReadTwice() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("")).thenReturn(3, 2);
            Command command = spy(this.getActiveCommand());
            this.menu.addCommand(this.getActiveCommand());
            this.menu.addCommand(command);
            this.menu.addCommand(this.getNotActiveCommand());
            this.menu.execute();
            verify(this.console, times(2)).writeln();
            verify(this.console, times(2)).writeln("----- Choose one option -----");
            verify(this.console, times(2)).writeln("1) " + MenuTest.COMMAND_TITLE_ACTIVE);
            verify(this.console, times(2)).writeln("2) " + MenuTest.COMMAND_TITLE_ACTIVE);
            verify(command).execute();
        }
    }

}
