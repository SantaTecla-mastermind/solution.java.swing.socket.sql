package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class TCPIPTest extends  usantatecla.utils.models.TCPIPTest {

    @Override
    protected TCPIP getTCPIP() {
        return new TCPIP(this.serverSocket, this.socket);
    }

    @Test
    public void testGivenTCPIPWhenSendColorThenCorrect() {
        Color color = Color.NULL;
        ((TCPIP) this.tcpip).send(color);
        verify(this.tcpip).send(color.name());
    }

    @Test
    public void testGivenTCPIPWhenSendNullColorThenNull() {
        ((TCPIP) this.tcpip).send((Color) null);
        verify(this.tcpip).send("null");
    }

    @Test
    public void testGivenTCPIPWhenSendErrorThenCorrect() {
        Error error = Error.NULL;
        ((TCPIP) this.tcpip).send(error);
        verify(this.tcpip).send(error.name());
    }

    @Test
    public void testGivenTCPIPWhenSendNullErrorThenNull() {
        ((TCPIP) this.tcpip).send((Error) null);
        verify(this.tcpip).send("null");
    }

    @Test
    public void testGivenTCPIPWhenReceiveErrorThenReturn() {
        Error error = Error.NULL;
        doReturn(error.name()).when(this.tcpip).receiveLine();
        assertThat(((TCPIP) this.tcpip).receiveError(), is(error));
    }

    @Test
    public void testGivenTCPIPWhenReceiveNullErrorThenReturnNull() {
        doReturn("null").when(this.tcpip).receiveLine();
        assertNull(((TCPIP) this.tcpip).receiveError());
    }

    @Test
    public void testGivenTCPIPWhenReceiveColorThenReturn() {
        Color color = Color.NULL;
        doReturn(color.name()).when(this.tcpip).receiveLine();
        assertThat(((TCPIP) this.tcpip).receiveColor(), is(color));
    }

    @Test
    public void testGivenTCPIPWhenReceiveNullColorThenReturnNull() {
        doReturn("null").when(this.tcpip).receiveLine();
        assertNull(((TCPIP) this.tcpip).receiveColor());
    }

    @Test
    public void testGivenTCPIPWhenCloseThenCorrect() {
        this.tcpip.close();
        verify(this.tcpip).send(FrameType.CLOSE.name());
        // verify(this.tcpip).close();
    }

}
