package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public abstract class DispatcherTest {

    @Mock
    protected TCPIP tcpip;

    protected Dispatcher dispatcher;

    @BeforeEach
    public void beforeEach() {
        this.dispatcher = this.getDispatcher();
        this.dispatcher.associate(this.tcpip);
    }

    protected abstract Dispatcher getDispatcher();
}
