package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;


import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class WinnerDispatcherTest {

    ArgumentCaptor<String> tcpipArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Mock
    TCPIP tcpip;
    Dispatcher dispatcher;

    @InjectMocks
    PlayController playController = new PlayController(new Session(this.tcpip),this.tcpip);
    //WinnerDispatcher winnerDispatcher = new WinnerDispatcher(this.playController);

    @Test
    public void testPrueba() {
        this.playController.isWinner();
        verify(this.tcpip).send(this.tcpipArgumentCaptor.capture());
        assertThat(this.tcpipArgumentCaptor.getAllValues().get(0),is(FrameType.WINNER.name()));
    }
}
