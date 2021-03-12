package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DispatcherPrototypeTest {

    @Mock
    private Dispatcher dispatcher;

    @Mock
    private TCPIP tcpip;

    private DispatcherPrototype dispatcherPrototype;
    private FrameType frameType;

    @BeforeEach
    public void beforeEach() {
        try (MockedStatic<TCPIP> tcpip = mockStatic(TCPIP.class)) {
            tcpip.when(TCPIP::createServerSocket).thenReturn(this.tcpip);
            this.dispatcherPrototype = spy(new DispatcherPrototype());
            this.frameType = FrameType.FINISHED;
            this.dispatcherPrototype.add(this.frameType, this.dispatcher);
        }
    }

    @Test
    public void testGivenDispatcherPrototypeWhenReciveFinishedThenDispatch() {
        when(this.tcpip.receiveLine()).thenReturn(this.frameType.name(), FrameType.CLOSE.name());
        this.dispatcherPrototype.serve();
        verify(this.dispatcherPrototype).dispatch(this.frameType);
        verify(this.dispatcher).dispatch();
        verify(this.tcpip).close();
    }

}
