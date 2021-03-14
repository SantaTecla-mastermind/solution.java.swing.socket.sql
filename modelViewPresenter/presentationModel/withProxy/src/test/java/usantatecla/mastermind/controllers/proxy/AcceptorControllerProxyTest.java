package usantatecla.mastermind.controllers.proxy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.AcceptorControllerTest;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class AcceptorControllerProxyTest extends AcceptorControllerTest {
    
    @Mock
    protected TCPIP tcpip;

    @Test
    public void testGivenAcceptorControllerProxyWhenNextStateThenCorrect() {
        this.acceptorController.nextState();
        verify(this.tcpip).send(FrameType.NEXT_STATE.name());
    }

    @Test
    public void testGivenAcceptorControllerProxyWhenGetStateValueThenReturn() {
        StateValue stateValue = StateValue.INITIAL;
        when(this.tcpip.receiveLine()).thenReturn(stateValue.name());
        assertThat(this.acceptorController.getStateValue(), is(stateValue));
    }

    @Test
    public void testGivenAcceptorControllerProxyWhenGetAttemptsThenReturn() {
        int attempts = 1;
        when(this.tcpip.receiveInt()).thenReturn(attempts);
        assertThat(this.acceptorController.getAttempts(), is(attempts));
    }

    @Test
    public void testGivenAcceptorControllerProxyWhenGetProposedCombinationColorsThenReturn() {
        when(this.tcpip.receiveInt()).thenReturn(Result.WIDTH);
        when(this.tcpip.receiveColor()).thenReturn(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        assertThat(this.acceptorController.getProposedCombinationColors(1), is(Color.get("rgby")));
    }

    @Test
    public void testGivenAcceptorControllerProxyWhenGetBlacksThenReturn() {
        int blacks = 2;
        when(this.tcpip.receiveInt()).thenReturn(blacks);
        assertThat(this.acceptorController.getBlacks(1), is(blacks));
    }

    @Test
    public void testGivenAcceptorControllerProxyWhenGetWhitesThenReturn() {
        int whites = 2;
        when(this.tcpip.receiveInt()).thenReturn(whites);
        assertThat(this.acceptorController.getWhites(1), is(whites));
    }

}
