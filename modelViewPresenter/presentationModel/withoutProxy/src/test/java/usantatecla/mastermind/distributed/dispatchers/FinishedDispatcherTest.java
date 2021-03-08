package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FinishedDispatcherTest extends DispatcherTest {

    @Mock
    private PlayController playController;

    @Override
    protected Dispatcher getDispatcher() {
        return new FinishedDispatcher(this.playController);
    }

    @Test
    public void testGivenFinishedDispatcherWhenDispatchThenCorrect() {
        when(this.playController.isFinished()).thenReturn(false);
        this.dispatcher.dispatch();
        verify(this.tcpip).send(false);
    }

}
