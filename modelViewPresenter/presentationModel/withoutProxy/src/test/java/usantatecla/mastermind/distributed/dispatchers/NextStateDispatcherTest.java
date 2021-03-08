package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;

public class NextStateDispatcherTest extends DispatcherTest {

    @Mock
    private PlayController playController;

    @Override
    protected Dispatcher getDispatcher() {
        return new NextStateDispatcher(this.playController);
    }

    @Test
    public void testGivenNextStateDispatcherWhenDispatchThenCorrect() {
        this.dispatcher.dispatch();
        verify(this.playController).nextState();
    }

}
