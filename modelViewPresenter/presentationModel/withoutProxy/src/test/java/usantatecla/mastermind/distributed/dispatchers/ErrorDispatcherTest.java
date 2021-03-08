package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ErrorDispatcherTest extends DispatcherTest {

    @Mock
    private PlayController playController;

    @Override
    protected Dispatcher getDispatcher() {
        return new ErrorDispatcher(this.playController);
    }

    @Test
    public void testGivenErrorDispatcherWhenDispatchThenCorrect() {
        Error error = Error.NULL;
        when(this.tcpip.receiveInt()).thenReturn(Result.WIDTH);
        when(this.tcpip.receiveColor()).thenReturn(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);
        when(this.playController.getError(any())).thenReturn(error);
        this.dispatcher.dispatch();
        verify(this.tcpip).send(error);
    }

}
