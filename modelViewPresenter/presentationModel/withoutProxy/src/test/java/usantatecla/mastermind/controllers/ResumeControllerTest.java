package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.distributed.dispatchers.FrameType;

import static org.mockito.Mockito.verify;

public class ResumeControllerTest extends AcceptorControllerTest {
    
    @Override
    protected ResumeController getServerAcceptorController() {
        return new ResumeController(this.session, null);
    }
    
    @Override
    protected ResumeController getClientAcceptorController() {
        return new ResumeController(this.session, this.tcpip);
    }
    
    @Test
    public void testGivenServerResumeControllerWhenResetThenCorrect() {
        this.getServerAcceptorController().reset();
        verify(this.session).reset();
    }

    @Test
    public void testGivenClientResumeControllerWhenResetThenCorrect() {
        this.getClientAcceptorController().reset();
        verify(this.tcpip).send(FrameType.RESET.name());
    }

}
