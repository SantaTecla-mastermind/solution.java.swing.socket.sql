package usantatecla.mastermind.controllers.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.distributed.dispatchers.FrameType;

import static org.mockito.Mockito.verify;

public class ResumeControllerProxyTest extends AcceptorControllerProxyTest {

    @BeforeEach
    public void beforeEach() {
        this.acceptorController = new ResumeControllerProxy(this.tcpip);
    }

    @Test
    public void testGivenResumeControllerProxyWhenResetThenCorrect() {
        ((ResumeControllerProxy) this.acceptorController).reset();
        verify(this.tcpip).send(FrameType.RESET.name());
    }

}
