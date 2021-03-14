package usantatecla.mastermind.controllers.implementation;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.controllers.AcceptorControllerTest;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public abstract class AcceptorControllerImplementationTest extends AcceptorControllerTest {

    @Test
    public void testGivenAcceptorControllerWhenNextStateThenCorrect() {
        this.acceptorController.nextState();
        verify(this.session).nextState();
    }

    @Test
    public void testGivenAcceptorControllerWhenGetStateValueThenReturn() {
        StateValue stateValue = StateValue.INITIAL;
        when(this.session.getValueState()).thenReturn(stateValue);
        assertThat(this.acceptorController.getStateValue(), is(stateValue));
    }

    @Test
    public void testGivenAcceptorControllerWhenGetAttemptsThenReturn() {
        int attempts = 1;
        when(this.session.getAttempts()).thenReturn(attempts);
        assertThat(this.acceptorController.getAttempts(), is(attempts));
    }

    @Test
    public void testGivenAcceptorControllerWhenGetProposedCombinationColorsThenReturn() {
        List<Color> colors = Color.get("rgby");
        when(this.session.getProposedCombinationColors(anyInt())).thenReturn(colors);
        assertThat(this.acceptorController.getProposedCombinationColors(1), is(colors));
    }

    @Test
    public void testGivenAcceptorControllerWhenGetBlacksThenReturn() {
        int blacks = 2;
        when(this.session.getBlacks(anyInt())).thenReturn(blacks);
        assertThat(this.acceptorController.getBlacks(1), is(blacks));
    }

    @Test
    public void testGivenAcceptorControllerWhenGetWhitesThenReturn() {
        int whites = 2;
        when(this.session.getWhites(anyInt())).thenReturn(whites);
        assertThat(this.acceptorController.getWhites(1), is(whites));
    }

}
