package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.models.StateValue;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StateValueDispatcherTest extends DispatcherTest {

    @Mock
    private PlayControllerImplementation playController;

    @Override
    protected Dispatcher getDispatcher() {
        return new StateValueDispatcher(this.playController);
    }

    @Test
    public void testGivenStateValueDispatcherWhenDispatchThenCorrect() {
        StateValue stateValue = StateValue.INITIAL;
        when(this.playController.getStateValue()).thenReturn(stateValue);
        this.dispatcher.dispatch();
        verify(this.tcpip).send(stateValue.toString());
    }

}
