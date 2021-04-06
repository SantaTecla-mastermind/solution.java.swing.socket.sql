package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class AcceptorControllerTest {
    
    @Mock
    protected Session session;

    @Mock
    protected TCPIP tcpip;

    @Test
	public void testGivenServerAcceptorControllerWhenNextStateThenCorrect() {
		this.getServerAcceptorController().nextState();
        verify(this.session).nextState();
	}

    protected abstract AcceptorController getServerAcceptorController();

    @Test
	public void testGivenClientAcceptorControllerWhenNextStateThenCorrect() {
		this.getClientAcceptorController().nextState();
        verify(this.tcpip).send(FrameType.NEXT_STATE.name());
	}

    protected abstract AcceptorController getClientAcceptorController();

    @Test
	public void testGivenServerAcceptorControllerWhenGetStateValueThenReturn() {
        StateValue stateValue = StateValue.INITIAL;
		when(this.session.getValueState()).thenReturn(stateValue);
        assertThat(this.getServerAcceptorController().getStateValue(), is(stateValue));
	}

    @Test
	public void testGivenServerAcceptorControllerWhenGetAttemptsThenReturn() {
		int attempts = 1;
        when(this.session.getAttempts()).thenReturn(attempts);
        assertThat(this.getServerAcceptorController().getAttempts(), is(attempts));
	}

    @Test
	public void testGivenClientAcceptorControllerWhenGetAttemptsThenReturn() {
		int attempts = 1;
        when(this.tcpip.receiveInt()).thenReturn(attempts);
        assertThat(this.getClientAcceptorController().getAttempts(), is(attempts));
	}

    @Test
	public void testGivenServerAcceptorControllerWhenGetProposedCombinationColorsThenReturn() {
		List<Color> colors = Color.get("rgby");
        when(this.session.getProposedCombinationColors(anyInt())).thenReturn(colors);
        assertThat(this.getServerAcceptorController().getProposedCombinationColors(1), is(colors));
	}

    @Test
	public void testGivenClientAcceptorControllerWhenGetProposedCombinationColorsThenReturn() {
		when(this.tcpip.receiveInt()).thenReturn(Result.WIDTH);
        when(this.tcpip.receiveColor()).thenReturn(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        assertThat(this.getClientAcceptorController().getProposedCombinationColors(1), is(Color.get("rgby")));
	}

    @Test
	public void testGivenServerAcceptorControllerWhenGetBlacksThenReturn() {
        int blacks = 2;
		when(this.session.getBlacks(anyInt())).thenReturn(blacks);
        assertThat(this.getServerAcceptorController().getBlacks(1), is(blacks));
	}

    @Test
	public void testGivenClientAcceptorControllerWhenGetBlacksThenReturn() {
        int blacks = 2;
		when(this.tcpip.receiveInt()).thenReturn(blacks);
        assertThat(this.getClientAcceptorController().getBlacks(1), is(blacks));
	}

    @Test
	public void testGivenServerAcceptorControllerWhenGetWhitesThenReturn() {
        int whites = 2;
		when(this.session.getWhites(anyInt())).thenReturn(whites);
        assertThat(this.getServerAcceptorController().getWhites(1), is(whites));
	}

    @Test
	public void testGivenClientAcceptorControllerWhenGetWhitesThenReturn() {
        int whites = 2;
		when(this.tcpip.receiveInt()).thenReturn(whites);
        assertThat(this.getClientAcceptorController().getWhites(1), is(whites));
	}

}
