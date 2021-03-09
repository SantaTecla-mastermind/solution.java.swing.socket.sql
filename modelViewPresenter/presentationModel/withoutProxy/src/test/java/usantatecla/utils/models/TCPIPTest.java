package usantatecla.utils.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TCPIPTest {

    @Mock
    private ServerSocket serverSocket;

    @Mock
    private Socket socket;

    @Mock
    private OutputStream outputStream;

    @Mock
    private InputStream inputStream;

    private TCPIP tcpip;

    @BeforeEach
    public void beforeEach() throws IOException {
        when(this.socket.getOutputStream()).thenReturn(this.outputStream);
        when(this.socket.getInputStream()).thenReturn(this.inputStream);
        this.tcpip = spy(new TCPIP(this.serverSocket, this.socket));
    }

    @Test
    public void testGivenTCPIPWhenSendStringThenCorrect() {
        String value = "value";
        this.tcpip.send(value);
        verify(this.tcpip).send(value);
    }

    @Test
    public void testGivenTCPIPWhenSendNumberThenCorrect() {
        int number = 1;
        this.tcpip.send(number);
        verify(this.tcpip).send(String.valueOf(number));
    }

    @Test
    public void testGivenTCPIPWhenSendBooleanThenCorrect() {
        this.tcpip.send(false);
        verify(this.tcpip).send(String.valueOf(false));
    }

    @Test
    public void testGivenTCPIPWhenReceiveLineThenReturn() throws IOException {
        String line = "line";
        doReturn(line).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveLine(), is(line));
    }

    @Test
    public void testGivenTCPIPWhenReceiveLineThenReturnError() throws IOException {
        doThrow(IOException.class).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveLine(), is(null));
    }

    @Test
    public void testGivenTCPIPWhenReceiveNumberThenReturn() throws IOException {
        int number = 1;
        doReturn(String.valueOf(number)).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveInt(), is(number));
    }

    @Test
    public void testGivenTCPIPWhenReceiveNumberThenReturnError() throws IOException {
        doThrow(IOException.class).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveInt(), is(-1));
    }

    @Test
    public void testGivenTCPIPWhenReceiveBooleanThenReturn() throws IOException {
        doReturn(String.valueOf(false)).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveBoolean(), is(false));
    }

    @Test
    public void testGivenTCPIPWhenReceiveBooleanThenReturnError() throws IOException {
        doThrow(IOException.class).when(this.tcpip).readLine();
        assertThat(this.tcpip.receiveBoolean(), is(false));
    }

    @Test
    public void testGivenTCPIPWhenCloseThenCorrect() throws IOException {
        this.tcpip.close();
        verify(this.socket).close();
        verify(this.tcpip).closeInAndOut();
        verify(this.serverSocket).close();
    }

}
