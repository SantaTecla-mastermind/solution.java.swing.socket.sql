package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.models.Command;
import usantatecla.utils.models.CommandTest;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RedoCommandTest extends CommandTest {

    @Mock
    private PlayController playController;

    @Override
    public Command getCommand() {
        return new RedoCommand(playController);
    }

    @Override
    public boolean isActive() {
        return this.getCommand().isActive();
    }

    @Override
    public String getTitle() {
        return Message.REDO_COMMAND.toString();
    }

    @Test
    public void testGivenUndoCommandWhenExecuteThenAdd() {
        this.getCommand().execute();
        verify(this.playController).redo();
    }
    
}
