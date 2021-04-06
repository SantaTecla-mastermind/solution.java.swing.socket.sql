package usantatecla.mastermind.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SessionTest {

    @Mock
    private TCPIP tcpip;

    @Test
    public void testGivenSessionServerWhenGetStateValueThenReturn() {
        assertThat(new Session(null).getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenSessionClientWhenGetStateValueThenReturn() {
        StateValue stateValue = StateValue.INITIAL;
        when(this.tcpip.receiveLine()).thenReturn(stateValue.name());
        assertThat(new Session(this.tcpip).getValueState(), is(stateValue));
    }

}
