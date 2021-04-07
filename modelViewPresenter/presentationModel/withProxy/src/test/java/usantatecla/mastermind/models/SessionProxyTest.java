package usantatecla.mastermind.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.mastermind.distributed.dispatchers.TCPIP;

@ExtendWith(MockitoExtension.class)
public class SessionProxyTest {

    @Mock
    private TCPIP tcpip;

    @Test
    public void testGivenSessionProxyWhenGetStateValueThenReturn() {
        StateValue stateValue = StateValue.INITIAL;
        when(this.tcpip.receiveLine()).thenReturn(stateValue.name());
        assertThat(new SessionProxy(this.tcpip).getValueState(), is(stateValue));
    }
    
}
