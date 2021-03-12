package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.ResumeController;

import static org.mockito.Mockito.verify;

public class ResetDispatcherTest extends DispatcherTest {

    @Mock
    private ResumeController resumeController;

    @Override
    protected Dispatcher getDispatcher() {
        return new ResetDispatcher(this.resumeController);
    }

    @Test
    public void testGivenResetDispatcherWhenDispatchThenCorrect() {
        this.dispatcher.dispatch();
        verify(this.resumeController).reset();
    }

}
