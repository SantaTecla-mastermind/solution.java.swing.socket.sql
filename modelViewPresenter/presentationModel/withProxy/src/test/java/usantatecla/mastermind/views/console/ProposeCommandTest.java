package usantatecla.mastermind.views.console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.models.Command;
import usantatecla.utils.models.CommandTest;
import usantatecla.utils.views.Console;

@ExtendWith(MockitoExtension.class)
public class ProposeCommandTest extends CommandTest {

    @Mock
    private Console console;

    private PlayController playController;

    @BeforeEach
    public void beforeEach() {
        this.playController = spy(new PlayControllerImplementation(new SessionImplementation()));
    }

    @Override
    public Command getCommand() {
        return new ProposeCommand(playController);
    }

    @Override
    public boolean isActive() {
        return this.getCommand().isActive();
    }

    @Override
    public String getTitle() {
        return Message.PROPOSE_COMMAND.toString();
    }

    @Test
    public void testGivenProposeCommandWhenExecuteThenAdd() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String initials = "rgby";
            when(this.console.readString(anyString())).thenReturn(initials);
            this.getCommand().execute();
            verify(this.playController).add(Color.get(initials));
        }
    }
    
}
