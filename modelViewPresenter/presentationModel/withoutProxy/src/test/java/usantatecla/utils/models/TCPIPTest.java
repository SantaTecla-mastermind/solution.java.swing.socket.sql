package usantatecla.utils.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TCPIPTest {

    @Mock
    protected ServerSocket serverSocket;

    @Mock
    protected Socket socket;

    @Mock
    protected OutputStream outputStream;

    @Mock
    protected InputStream inputStream;

    protected TCPIP tcpip;

    protected TCPIP getTCPIP() {
        return new TCPIP(this.serverSocket, this.socket);
    }

    @BeforeEach
    public void beforeEach() throws IOException {
        when(this.socket.getOutputStream()).thenReturn(this.outputStream);
        when(this.socket.getInputStream()).thenReturn(this.inputStream);
        this.tcpip = spy(this.getTCPIP());
    }

    @Test
    public void testGivenTCPIPWhenSendStringThenCorrect() {
        String value = "value";
        this.tcpip.send(value);
        verify(this.tcpip).println(value);
    }

    @Test
    public void testGivenTCPIPWhenSendNumberThenCorrect() {
        int number = 1;
        this.tcpip.send(number);
        verify(this.tcpip).println(String.valueOf(number));
    }

    @Test
    public void testGivenTCPIPWhenSendBooleanThenCorrect() {
        this.tcpip.send(false);
        verify(this.tcpip).println(String.valueOf(false));
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
        assertNull(this.tcpip.receiveLine());
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
